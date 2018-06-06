package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class AntallMåVæreSpesifisertException extends BadRequestException {

    public AntallMåVæreSpesifisertException(String message, Throwable cause) {
        super(message, cause);
    }
}
