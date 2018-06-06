package no.nav.opptjening.skatt.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class UgyldigPersonidentifikator extends BadRequestException {
    public UgyldigPersonidentifikator(String s, Throwable cause) {
        super(s, cause);
    }
}
