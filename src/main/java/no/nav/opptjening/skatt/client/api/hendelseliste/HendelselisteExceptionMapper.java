package no.nav.opptjening.skatt.client.api.hendelseliste;

import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.api.BasicSkatteetatenFeilmeldingExceptionMapper;
import no.nav.opptjening.skatt.client.api.hendelseliste.exceptions.*;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HendelselisteExceptionMapper extends BasicSkatteetatenFeilmeldingExceptionMapper {
    @Nullable
    public HttpException mapFeilmeldingToHttpException(@NotNull Feilmelding feilmelding) {
        HttpException exception = super.mapFeilmeldingToHttpException(feilmelding);
        if (exception != null) {
            return exception;
        }

        switch (feilmelding.getKode()) {
            case "FA-001":
                return new SekvensnummerMåVæreSattException("fraSekvensnummer må være satt");
            case "FA-002":
                return new SekvensnummerMåVæreStørreEnnNullException("fraSekvensnummer må være større enn 0");
            case "FA-003":
                return new AntallMåVæreSpesifisertException("antall må være spesifisert");
            case "FA-004":
                return new AntallMåVæreStørreEnnNullException("antall må være større enn 0");
            case "FA-009":
                return new DatabasenErUtilgjengeligException("Fikk ikke hentet data fra databasen, vennligst prøv igjen senere!");
            case "FA-010":
                return new FantIngenInformasjonException("Fant ingen informasjon i databasen");
            case "FA-013":
                return new UgyldigDatoformatException("Dato har ugyldig format. Forventet YYYY-MM-DD.");
            case "FA-014":
                return new FantIngenSekvensnummerException("Fant ingen sekvensnummer.");
            case "FA-015":
                return new UgyldigDokumenttypeException("Ugyldig dokumenttype.");
        }

        return null;
    }
}
