package no.nav.opptjening.skatt.client.exceptions;

public class BadRequestException extends ClientException {

    public BadRequestException(String message, Throwable cause) {
        super(400, message, cause);
    }
}
