package no.nav.opptjening.skatt.api.hendelseliste;

import no.nav.opptjening.skatt.api.AbstractFeilmeldingMapperTest;
import no.nav.opptjening.skatt.api.FeilmeldingTestCase;
import no.nav.opptjening.skatt.api.hendelseliste.exceptions.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HendelselisteExceptionMapperTest extends AbstractFeilmeldingMapperTest {
    private static final List<FeilmeldingTestCase> testCases = Arrays.asList(new FeilmeldingTestCase("FA-001", "fraSekvensnummer må være satt",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, SekvensnummerMåVæreSattException.class, "fraSekvensnummer må være satt"),
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
