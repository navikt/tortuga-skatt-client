package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class SekvensnummerMåVæreStørreEnnNullException extends BadRequestException {

    public SekvensnummerMåVæreStørreEnnNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
