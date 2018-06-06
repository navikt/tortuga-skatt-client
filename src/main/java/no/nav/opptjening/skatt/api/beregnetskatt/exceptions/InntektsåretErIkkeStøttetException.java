package no.nav.opptjening.skatt.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class InntektsåretErIkkeStøttetException extends BadRequestException {
    public InntektsåretErIkkeStøttetException(String s, Throwable cause) {
        super(s, cause);
    }
}
