package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class AntallMåVæreStørreEnnNullException extends BadRequestException {

    public AntallMåVæreStørreEnnNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
