package no.nav.opptjening.skatt.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.exceptions.NotFoundException;

public class FantIkkeBeregnetSkattException extends NotFoundException {
    public FantIkkeBeregnetSkattException(String s, Throwable cause) {
        super(s, cause);
    }
}
