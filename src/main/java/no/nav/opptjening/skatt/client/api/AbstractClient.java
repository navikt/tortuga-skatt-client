package no.nav.opptjening.skatt.client.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.FeilmeldingMapper;
import no.nav.opptjening.skatt.client.api.exceptions.ResponseUnmappableException;
import no.nav.opptjening.skatt.client.api.exceptions.UkjentFeilkodeException;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import no.nav.opptjening.skatt.client.schema.hendelsesliste.FeilmeldingDto;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;

public abstract class AbstractClient<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractClient.class);

    private T api;

    private HttpExceptionMapper httpExceptionMapper = new HttpExceptionMapper.BasicHttpExceptionMapper();

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final ErrorResponseMapper errorResponseMapper;

    protected AbstractClient(String endepunkt, String apiKey, Class<T> api) {
        Retrofit retrofit = createRetrofit(createHttpClient(apiKey), endepunkt, JacksonConverterFactory.create(objectMapper));

        this.api = retrofit.create(api);

        this.errorResponseMapper = new DefaultErrorMapper(retrofit);
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

    @NotNull
    protected <S, R> S executeRequest(@NotNull Call<R> request, @NotNull SuccessfulResponseMapper<R, S> responseMapper,
                                      @NotNull FeilmeldingExceptionMapper exceptionMapper) throws HttpException, IOException {
        Response<R> response;
        try {
            response = request.execute();
        } catch (JsonMappingException e) {
            throw new ResponseUnmappableException("Kan ikke mappe JSON-respons til den angitte klassen på grunn av skjemafeil", e);
        }

        if (!response.isSuccessful()) {
            throw handleErrorResponse(response, exceptionMapper);
        }

        return handleSuccessfulResponse(response, responseMapper);
    }

    @NotNull
    private <S, R> S handleSuccessfulResponse(@NotNull Response<R> response, @NotNull SuccessfulResponseMapper<R, S> responseMapper) {
        try {
            R responseBody = response.body();
            if (responseBody == null) {
                throw new NullPointerException("Response body is null");
            }
            return responseMapper.mapToResponse(responseBody);
        } catch (Exception e) {
            throw new ResponseUnmappableException("Kan ikke mappe til den angitte klassen på grunn av valideringsfeil", e);
        }
    }

    @NotNull
    private <S> HttpException handleErrorResponse(@NotNull Response<S> response, @NotNull FeilmeldingExceptionMapper exceptionMapper) {
        try {
            ResponseBody errorBody = response.errorBody();
            if (errorBody == null) {
                throw new NullPointerException("Error body is null");
            }
            Feilmelding feilmelding = errorResponseMapper.mapErrorResponse(errorBody);

            HttpException ex = exceptionMapper.mapFeilmeldingToHttpException(feilmelding);

            if (ex != null) {
                return ex;
            }

            return new UkjentFeilkodeException(response.code(),
                    "Kunne ikke mappe Feilmelding=" + feilmelding.toString() + " til HttpException pga ukjent feilkode", null);
        } catch (Exception e) {
            return httpExceptionMapper.mapResponseToHttpException(response, e);
        }
    }

    public static class DefaultErrorMapper implements ErrorResponseMapper {
        private final Retrofit retrofit;

        private final FeilmeldingMapper feilmeldingMapper = new FeilmeldingMapper();

        public DefaultErrorMapper(Retrofit retrofit) {
            this.retrofit = retrofit;
        }

        @NotNull
        @Override
        public Feilmelding mapErrorResponse(@NotNull ResponseBody errorBody) {
            FeilmeldingDto error = mapErrorResponseToDto(errorBody);
            return feilmeldingMapper.mapToFeilmelding(error);
        }

        @NotNull
        private FeilmeldingDto mapErrorResponseToDto(@NotNull ResponseBody errorResponse) {
            try {
                Converter<ResponseBody, FeilmeldingDto> converter = retrofit.responseBodyConverter(FeilmeldingDto.class, new Annotation[0]);
                return converter.convert(errorResponse);
            } catch (JsonMappingException e) {
                throw new ResponseUnmappableException("Kan ikke mappe respons til Feilmelding på grunn av skjemafeil", e);
            } catch (IOException e) {
                throw new ResponseUnmappableException("Kan ikke mappe respons til Feilmelding", e);
            }
        }
    }
}
