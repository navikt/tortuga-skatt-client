package no.nav.opptjening.skatt.api.hendelseliste;

import no.nav.opptjening.skatt.Feilmelding;
import no.nav.opptjening.skatt.api.FeilmeldingExceptionMapper;
import no.nav.opptjening.skatt.api.hendelseliste.exceptions.*;
import no.nav.opptjening.skatt.exceptions.BadRequestException;
import no.nav.opptjening.skatt.exceptions.HttpException;

public class HendelselisteExceptionMapper implements FeilmeldingExceptionMapper {
    public HttpException mapFeilmeldingToHttpException(Feilmelding feilmelding, Throwable cause) {
        switch (feilmelding.getKode()) {
            case "FA-001":
                return new SekvensnummerMåVæreSattException("fraSekvensnummer må være satt", cause);
            case "FA-002":
                return new SekvensnummerMåVæreStørreEnnNullException("fraSekvensnummer må være større enn 0", cause);
            case "FA-003":
                return new AntallMåVæreSpesifisertException("antall må være spesifisert", cause);
            case "FA-004":
                return new AntallMåVæreStørreEnnNullException("antall må være større enn 0", cause);
            case "FA-009":
                return new DatabasenErUtilgjengeligException("Fikk ikke hentet data fra databasen, vennligst prøv igjen senere!", cause);
            case "FA-010":
                return new FantIngenInformasjonException("Fant ingen informasjon i databasen", cause);
            case "FA-013":
                return new UgyldigDatoformatException("Dato har ugyldig format. Forventet YYYY-MM-DD.", cause);
            case "FA-014":
                return new FantIngenSekvensnummerException("Fant ingen sekvensnummer.", cause);
            case "FA-015":
                return new UgyldigDokumenttypeException("Ugyldig dokumenttype.", cause);
        }

        return null;
    }
}
