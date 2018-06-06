package no.nav.opptjening.skatt.client.api.hendelseliste.exceptions;

import no.nav.opptjening.skatt.client.exceptions.BadRequestException;

public class UgyldigDokumenttypeException extends BadRequestException {
    public UgyldigDokumenttypeException(String message) {
        this(message, null);
    }

    public UgyldigDokumenttypeException(String s, Throwable cause) {
        super(s, cause);
    }
}
