package no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class UgyldigInntektsårException extends BadRequestException {
    public UgyldigInntektsårException(String s, Throwable cause) {
        super(s, cause);
    }
}
