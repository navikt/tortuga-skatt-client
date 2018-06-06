package no.nav.opptjening.skatt.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class UgyldigInntektsårException extends BadRequestException {
    public UgyldigInntektsårException(String s, Throwable cause) {
        super(s, cause);
    }
}
