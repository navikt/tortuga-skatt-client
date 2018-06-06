package no.nav.opptjening.skatt.client.api.beregnetskatt;

import no.nav.opptjening.skatt.client.api.AbstractFeilmeldingExceptionMapperTest;
import no.nav.opptjening.skatt.client.api.FeilmeldingTestCase;
import no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions.*;
import no.nav.opptjening.skatt.client.exceptions.ForbiddenException;
import no.nav.opptjening.skatt.client.exceptions.InternalServerErrorException;
import no.nav.opptjening.skatt.client.exceptions.NotFoundException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BeregnetSkattExceptionMapperTest extends AbstractFeilmeldingExceptionMapperTest {

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
            new FeilmeldingTestCase("BSA-005", "Det forespurte inntektsåret er ikke støttet",
            "52e3ce7eb8df80fa6a135dc6eae475f6", 400, InntektsåretErIkkeStøttetException.class, "Det forespurte inntektsåret er ikke støttet"),
            new FeilmeldingTestCase("BSA-006", "Fant ikke Beregnet Skatt for gitt inntektsår og identifikator",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 404, FantIkkeBeregnetSkattException.class, "Fant ikke Beregnet Skatt for gitt inntektsår og identifikator"),
            new FeilmeldingTestCase("BSA-007", "Inntektsår har ikke gyldig format",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, UgyldigInntektsårException.class, "Inntektsår har ikke gyldig format"),
            new FeilmeldingTestCase("BSA-008", "Personidentifikator har ikke gyldig format",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 400, UgyldigPersonidentifikator.class, "Personidentifikator har ikke gyldig format"),
            new FeilmeldingTestCase("BSA-009", "Fant ingen person for gitt identifikator",
                    "52e3ce7eb8df80fa6a135dc6eae475f6", 404, FantIngenPersonException.class, "Fant ingen person for gitt identifikator"));

    @Test
    public void mapFeilmeldingToHttpException() throws Exception {
        runTests(new BeregnetSkattExceptionMapper(), testCases);
    }

}
