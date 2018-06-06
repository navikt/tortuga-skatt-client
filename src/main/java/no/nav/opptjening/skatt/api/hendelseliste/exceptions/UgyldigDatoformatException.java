package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class UgyldigDatoformatException extends BadRequestException {
    public UgyldigDatoformatException(String s, Throwable cause) {
        super(s, cause);
    }
}
