package no.nav.opptjening.skatt.api;

import no.nav.opptjening.skatt.api.exceptions.ResponseUnmappableException;
import no.nav.opptjening.skatt.api.exceptions.UkjentFeilkodeException;
import no.nav.opptjening.skatt.exceptions.HttpException;
import no.nav.opptjening.skatt.schema.hendelsesliste.Feilmelding;
import no.nav.opptjening.skatt.schema.hendelsesliste.Hendelsesliste;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.apache.avro.AvroRuntimeException;
import org.apache.avro.AvroTypeException;
import org.apache.avro.Schema;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.JsonDecoder;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public abstract class AbstractClient<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractClient.class);

    private T api;

    private HttpExceptionMapper httpExceptionMapper = new HttpExceptionMapper.BasicHttpExceptionMapper();

    private SkatteetatenErrorResponseMapper errorResponseMapper;

    protected AbstractClient(String endepunkt, String apiKey, Class<T> api) {
        Retrofit retrofit = createRetrofit(createHttpClient(apiKey), endepunkt);

        this.api = retrofit.create(api);
        this.errorResponseMapper = new SkatteetatenErrorResponseMapper(retrofit);
    }

    private static OkHttpClient createHttpClient(String apiKey) {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new RequestResponseLogger()))
                .addInterceptor(new HeaderInterceptor("X-NAV-APIKEY", apiKey))
                .build();
    }

    private static AvroConverterFactory createConverterFactory() {
        return AvroConverterFactory.builder().addConverter(Hendelsesliste.class, (Converter<ResponseBody, Hendelsesliste>) value -> {
            // TODO: if skatteetaten ever changes the key "hendelse" to "hendelser", there's no more need for a separate writer schema
            Schema writerSchema = new Schema.Parser().parse("{\n" +
                    "  \"namespace\": \"no.nav.opptjening.skatt.schema.hendelsesliste\",\n" +
                    "  \"type\": \"record\",\n" +
                    "  \"name\": \"Hendelsesliste\",\n" +
                    "  \"fields\": [\n" +
                    "    {\n" +
                    "      \"name\": \"hendelse\",\n" +
                    "      \"type\": {\n" +
                    "        \"type\": \"array\",\n" +
                    "        \"items\": {\n" +
                    "          \"name\": \"Hendelse\",\n" +
                    "          \"type\": \"record\",\n" +
                    "          \"fields\": [\n" +
                    "            {\n" +
                    "              \"name\": \"sekvensnummer\",\n" +
                    "              \"type\": \"long\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"name\": \"identifikator\",\n" +
                    "              \"type\": \"string\"\n" +
                    "            },\n" +
                    "            {\n" +
                    "              \"name\": \"gjelderPeriode\",\n" +
                    "              \"type\": \"string\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}");

            String jsonString = value.string();
            JsonDecoder jsonDecoder = DecoderFactory.get().jsonDecoder(writerSchema, jsonString);

            try {
                SpecificDatumReader<Hendelsesliste> reader = new SpecificDatumReader<>(Hendelsesliste.SCHEMA$);
                return reader.read(null, jsonDecoder);
            } catch (AvroTypeException e) {
                // TODO: remove this workaround as soon as Skatteetaten changes the response when the hendelsesliste has been read in full.
                if ("{}".equals(jsonString.replaceAll("\\s+",""))) {
                    return Hendelsesliste.newBuilder().build();
                }

                throw e;
            } finally {
                value.close();
            }
        }).build();
    }

    private static Retrofit createRetrofit(OkHttpClient client, String baseUrl) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(createConverterFactory())
                .build();
    }

    protected T getApi() {
        return api;
    }

    abstract protected FeilmeldingMapper getExceptionMapper();

    protected <S> S executeRequest(Call<S> request) throws HttpException, IOException {
        Response<S> response;
        try {
            response = request.execute();
        } catch (AvroRuntimeException e) {
            throw new ResponseUnmappableException("Kan ikke mappe JSON-respons til den angitte klassen på grunn av skjemafeil", e);
        }

        if (response.isSuccessful()) {
            return response.body();
        }

        throw handleErrorResponse(response);
    }

    private <S> HttpException handleErrorResponse(Response<S> response) {
        try {
            Feilmelding error = errorResponseMapper.mapErrorResponseToFeilmelding(response);

            HttpException ex = getExceptionMapper().mapFeilmeldingToHttpException(error, null);

            if (ex != null) {
                return ex;
            }

            return new UkjentFeilkodeException(response.code(),
                    "Kunne ikke mappe Feilmelding=" + error.toString() + " til HttpException pga ukjent feilkode", null);
        } catch (Exception e) {
            return httpExceptionMapper.mapResponseToHttpException(response, e);
        }
    }

}
