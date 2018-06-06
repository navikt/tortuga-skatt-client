package no.nav.opptjening.skatt.client.exceptions;

public class InternalServerErrorException extends ServerException {
    public InternalServerErrorException(String message) {
        this(message, null);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(500, message, cause);
    }
}
