package no.nav.opptjening.skatt.api.beregnetskatt;

import no.nav.opptjening.skatt.api.AbstractFeilmeldingMapperTest;
import no.nav.opptjening.skatt.api.FeilmeldingTestCase;
import no.nav.opptjening.skatt.api.beregnetskatt.exceptions.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BeregnetSkattExceptionMapperTest extends AbstractFeilmeldingMapperTest {

    private static final List<FeilmeldingTestCase> testCases = Arrays.asList(new FeilmeldingTestCase("BSA-005", "Det forespurte inntektsåret er ikke støttet",
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
