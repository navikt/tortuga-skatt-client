package no.nav.opptjening.skatt.client.api;

import no.nav.opptjening.skatt.client.exceptions.ClientException;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import no.nav.opptjening.skatt.client.exceptions.ServerException;
import retrofit2.Response;

public interface HttpExceptionMapper {
    <T> HttpException mapResponseToHttpException(Response<T> response, Throwable cause);

    class BasicHttpExceptionMapper implements HttpExceptionMapper {
        public HttpException mapResponseToHttpException(Response response, Throwable cause) {
            if (response.code() < 500) {
                return new ClientException(response.code(), "Ukjent feil fra Skatteetaten", cause);
            }

            return new ServerException(response.code(), "Ukjent feil fra Skatteetaten", cause);
        }
    }
}
