package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.NotFoundException;

public class FantIngenSekvensnummerException extends NotFoundException {

    public FantIngenSekvensnummerException(String message, Throwable cause) {
        super(message, cause);
    }
}
