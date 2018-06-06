package no.nav.opptjening.skatt.client.api.exceptions;

import no.nav.opptjening.skatt.client.exceptions.HttpException;

public class UkjentFeilkodeException extends HttpException {
    public UkjentFeilkodeException(int httpStatus, String message, Throwable cause) {
        super(httpStatus, message, cause);
    }
}
