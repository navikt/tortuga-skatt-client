package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class SekvensnummerMåVæreSattException extends BadRequestException {

    public SekvensnummerMåVæreSattException(String message, Throwable cause) {
        super(message, cause);
    }
}
