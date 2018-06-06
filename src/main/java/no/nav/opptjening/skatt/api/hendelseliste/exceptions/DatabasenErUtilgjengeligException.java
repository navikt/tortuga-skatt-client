package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.InternalServerErrorException;

public class DatabasenErUtilgjengeligException extends InternalServerErrorException {

    public DatabasenErUtilgjengeligException(String message, Throwable cause) {
        super(message, cause);
    }
}
