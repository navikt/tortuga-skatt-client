package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.InternalServerErrorException;

public class DatabasenErUtilgjengeligException extends InternalServerErrorException {

    public DatabasenErUtilgjengeligException(String message, Throwable cause) {
        super(message, cause);
    }
}
