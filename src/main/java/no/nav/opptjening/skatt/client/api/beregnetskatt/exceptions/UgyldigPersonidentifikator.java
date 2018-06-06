package no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class UgyldigPersonidentifikator extends BadRequestException {
    public UgyldigPersonidentifikator(String message) {
        this(message, null);
    }

    public UgyldigPersonidentifikator(String s, Throwable cause) {
        super(s, cause);
    }
}
