package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class SekvensnummerMåVæreStørreEnnNullException extends BadRequestException {

    public SekvensnummerMåVæreStørreEnnNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
