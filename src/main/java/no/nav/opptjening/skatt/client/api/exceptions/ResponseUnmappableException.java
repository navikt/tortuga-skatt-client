package no.nav.opptjening.skatt.client.api.exceptions;

public class ResponseUnmappableException extends RuntimeException {
    public ResponseUnmappableException(String message, Throwable cause) {
        super(message, cause);
    }
}
