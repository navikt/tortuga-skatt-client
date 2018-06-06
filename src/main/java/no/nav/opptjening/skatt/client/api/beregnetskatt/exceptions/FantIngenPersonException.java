package no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions;

import no.nav.opptjening.skatt.client.exceptions.NotFoundException;

public class FantIngenPersonException extends NotFoundException {
    public FantIngenPersonException(String s, Throwable cause) {
        super(s, cause);
    }
}
