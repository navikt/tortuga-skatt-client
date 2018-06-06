package no.nav.opptjening.skatt.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.exceptions.BadRequestException;

public class UgyldigDokumenttypeException extends BadRequestException {
    public UgyldigDokumenttypeException(String s, Throwable cause) {
        super(s, cause);
    }
}
