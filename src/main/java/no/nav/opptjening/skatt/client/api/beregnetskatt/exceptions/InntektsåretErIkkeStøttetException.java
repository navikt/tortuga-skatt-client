package no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class InntektsåretErIkkeStøttetException extends BadRequestException {
    public InntektsåretErIkkeStøttetException(String message) {
        this(message, null);
    }

    public InntektsåretErIkkeStøttetException(String s, Throwable cause) {
        super(s, cause);
    }
}
