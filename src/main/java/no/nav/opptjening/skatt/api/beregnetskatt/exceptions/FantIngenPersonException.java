package no.nav.opptjening.skatt.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.exceptions.NotFoundException;

public class FantIngenPersonException extends NotFoundException {
    public FantIngenPersonException(String s, Throwable cause) {
        super(s, cause);
    }
}
