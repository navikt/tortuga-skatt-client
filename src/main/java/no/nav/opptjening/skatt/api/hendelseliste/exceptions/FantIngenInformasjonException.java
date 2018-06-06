package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.NotFoundException;

public class FantIngenInformasjonException extends NotFoundException {

    public FantIngenInformasjonException(String message, Throwable cause) {
        super(message, cause);
    }
}
