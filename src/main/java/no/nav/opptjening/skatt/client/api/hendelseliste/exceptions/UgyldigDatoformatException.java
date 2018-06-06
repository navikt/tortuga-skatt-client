package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class UgyldigDatoformatException extends BadRequestException {
    public UgyldigDatoformatException(String message) {
        this(message, null);
    }

    public UgyldigDatoformatException(String s, Throwable cause) {
        super(s, cause);
    }
}
