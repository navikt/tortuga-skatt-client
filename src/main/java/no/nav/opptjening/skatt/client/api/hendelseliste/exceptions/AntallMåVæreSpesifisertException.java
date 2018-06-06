package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class AntallMåVæreSpesifisertException extends BadRequestException {

    public AntallMåVæreSpesifisertException(String message) {
        this(message, null);
    }

    public AntallMåVæreSpesifisertException(String message, Throwable cause) {
        super(message, cause);
    }
}
