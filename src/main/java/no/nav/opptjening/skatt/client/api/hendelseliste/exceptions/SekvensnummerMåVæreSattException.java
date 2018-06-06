package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class SekvensnummerMåVæreSattException extends BadRequestException {

    public SekvensnummerMåVæreSattException(String message) {
        this(message, null);
    }

    public SekvensnummerMåVæreSattException(String message, Throwable cause) {
        super(message, cause);
    }
}
