package no.nav.opptjening.skatt.client.api;

import no.nav.opptjening.skatt.client.exceptions.ForbiddenException;
import no.nav.opptjening.skatt.client.exceptions.InternalServerErrorException;
import no.nav.opptjening.skatt.client.exceptions.NotFoundException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BasicSkatteetatenFeilmeldingExceptionMapperTest extends AbstractFeilmeldingExceptionMapperTest {
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
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 403, ForbiddenException.class, "Du er ikke autorisert for tilgang til den forespurte ressursen."));

    @Test
    public void mapFeilmeldingToHttpException() throws Exception {
        runTests(new BasicSkatteetatenFeilmeldingExceptionMapper(), testCases);
    }

}
