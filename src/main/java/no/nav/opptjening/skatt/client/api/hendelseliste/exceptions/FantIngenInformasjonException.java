package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.NotFoundException;

public class FantIngenInformasjonException extends NotFoundException {

    public FantIngenInformasjonException(String message, Throwable cause) {
        super(message, cause);
    }
}
