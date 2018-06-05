package no.nav.opptjening.skatt.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.opptjening.skatt.api.exceptions.ResponseUnmappableException;
import no.nav.opptjening.skatt.api.exceptions.UkjentFeilkodeException;
import no.nav.opptjening.skatt.exceptions.HttpException;
import no.nav.opptjening.skatt.schema.hendelsesliste.Feilmelding;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public abstract class AbstractClient<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractClient.class);

    private T api;

    private HttpExceptionMapper httpExceptionMapper = new HttpExceptionMapper.BasicHttpExceptionMapper();

    private SkatteetatenErrorResponseMapper errorResponseMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    protected AbstractClient(String endepunkt, String apiKey, Class<T> api) {
        Retrofit retrofit = createRetrofit(createHttpClient(apiKey), endepunkt, JacksonConverterFactory.create(objectMapper));

        this.api = retrofit.create(api);
        this.errorResponseMapper = new SkatteetatenErrorResponseMapper(objectMapper);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private static OkHttpClient createHttpClient(String apiKey) {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new RequestResponseLogger()))
                .addInterceptor(new HeaderInterceptor("X-NAV-APIKEY", apiKey))
                .build();
    }

    private static Retrofit createRetrofit(OkHttpClient client, String baseUrl, Converter.Factory factory) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(factory)
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
        } catch (JsonMappingException e) {
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
