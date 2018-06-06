package no.nav.opptjening.skatt.client.exceptions;

public class ForbiddenException extends ClientException {
    public ForbiddenException(String message) {
        this(message, null);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(403, message, cause);
    }
}
