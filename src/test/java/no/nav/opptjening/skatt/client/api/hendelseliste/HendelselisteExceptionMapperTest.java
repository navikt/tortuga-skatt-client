package no.nav.opptjening.skatt.client.api.hendelseliste;

import no.nav.opptjening.skatt.client.api.AbstractFeilmeldingExceptionMapperTest;
import no.nav.opptjening.skatt.client.api.FeilmeldingTestCase;
import no.nav.opptjening.skatt.client.api.hendelseliste.exceptions.*;
import no.nav.opptjening.skatt.client.exceptions.ForbiddenException;
import no.nav.opptjening.skatt.client.exceptions.InternalServerErrorException;
import no.nav.opptjening.skatt.client.exceptions.NotFoundException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HendelselisteExceptionMapperTest extends AbstractFeilmeldingExceptionMapperTest {
    private static final List<FeilmeldingTestCase> testCases = Arrays.asList(new FeilmeldingTestCase("DAS-001", "Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, InternalServerErrorException.class, "Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!"),
            new FeilmeldingTestCase("DAS-002", "Den forespurte URLen svarer ikke til et gyldig endepunkt",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 404, NotFoundException.class, "Den forespurte URLen svarer ikke til et gyldig endepunkt"),
            new FeilmeldingTestCase("DAS-003", "Den forespurte informasjonen er for øyeblikket utilgjengelig, vennligst prøv igjen senere! Dersom problemet vedvarer, ta kontakt med brukerstøtte!",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, InternalServerErrorException.class, "Den forespurte informasjonen er for øyeblikket utilgjengelig, vennligst prøv igjen senere! Dersom problemet vedvarer, ta kontakt med brukerstøtte!"),
            new FeilmeldingTestCase("DAS-004", "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, InternalServerErrorException.class, "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten"),
            new FeilmeldingTestCase("DAS-005", "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, InternalServerErrorException.class, "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten"),
            new FeilmeldingTestCase("DAS-006", "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, InternalServerErrorException.class, "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten"),
            new FeilmeldingTestCase("DAS-007", "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, InternalServerErrorException.class, "Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten"),
            new FeilmeldingTestCase("DAS-008", "Du er ikke autorisert for tilgang til den forespurte ressursen.",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 403, ForbiddenException.class, "Du er ikke autorisert for tilgang til den forespurte ressursen."),
            new FeilmeldingTestCase("FA-001", "fraSekvensnummer må være satt",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400,SekvensnummerMåVæreSattException.class, "fraSekvensnummer må være satt"),
            new FeilmeldingTestCase("FA-002", "fraSekvensnummer må være større enn 0",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, SekvensnummerMåVæreStørreEnnNullException.class, "fraSekvensnummer må være større enn 0"),
            new FeilmeldingTestCase("FA-003", "antall må være spesifisert",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, AntallMåVæreSpesifisertException.class, "antall må være spesifisert"),
            new FeilmeldingTestCase("FA-004", "antall må være større enn 0",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, AntallMåVæreStørreEnnNullException.class, "antall må være større enn 0"),
            new FeilmeldingTestCase("FA-009", "Fikk ikke hentet data fra databasen, vennligst prøv igjen senere!",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 500, DatabasenErUtilgjengeligException.class, "Fikk ikke hentet data fra databasen, vennligst prøv igjen senere!"),
            new FeilmeldingTestCase("FA-010", "Fant ingen informasjon i databasen",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 404, FantIngenInformasjonException.class, "Fant ingen informasjon i databasen"),
            new FeilmeldingTestCase("FA-013", "Dato har ugyldig format. Forventet YYYY-MM-DD.",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, UgyldigDatoformatException.class, "Dato har ugyldig format. Forventet YYYY-MM-DD."),
            new FeilmeldingTestCase("FA-014", "Fant ingen sekvensnummer.",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 404, FantIngenSekvensnummerException.class, "Fant ingen sekvensnummer."),
            new FeilmeldingTestCase("FA-015", "Ugyldig dokumenttype.",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, UgyldigDokumenttypeException.class, "Ugyldig dokumenttype."));

    @Test
    public void mapFeilmeldingToHttpException() throws Exception {
        runTests(new HendelselisteExceptionMapper(), testCases);
    }

}
