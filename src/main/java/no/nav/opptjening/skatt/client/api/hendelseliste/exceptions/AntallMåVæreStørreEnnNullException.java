package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class AntallMåVæreStørreEnnNullException extends BadRequestException {

    public AntallMåVæreStørreEnnNullException(String message) {
        this(message, null);
    }

    public AntallMåVæreStørreEnnNullException(String message, Throwable cause) {
        super(message, cause);
    }
}
