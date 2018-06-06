package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.NotFoundException;

public class FantIngenSekvensnummerException extends NotFoundException {

    public FantIngenSekvensnummerException(String message, Throwable cause) {
        super(message, cause);
    }
}
