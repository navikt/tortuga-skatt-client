package no.nav.opptjening.skatt.client.api.beregnetskatt;

import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.api.BasicSkatteetatenFeilmeldingExceptionMapper;
import no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions.*;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BeregnetSkattExceptionMapper extends BasicSkatteetatenFeilmeldingExceptionMapper {
    @Nullable
    public HttpException mapFeilmeldingToHttpException(@NotNull Feilmelding feilmelding) {
        HttpException exception = super.mapFeilmeldingToHttpException(feilmelding);
        if (exception != null) {
            return exception;
        }

        switch (feilmelding.getKode()) {
            case "BSA-005":
                return new InntektsåretErIkkeStøttetException("Det forespurte inntektsåret er ikke støttet");
            case "BSA-006":
                return new FantIkkeBeregnetSkattException("Fant ikke Beregnet Skatt for gitt inntektsår og identifikator");
            case "BSA-007":
                return new UgyldigInntektsårException("Inntektsår har ikke gyldig format");
            case "BSA-008":
                return new UgyldigPersonidentifikator("Personidentifikator har ikke gyldig format");
            case "BSA-009":
                return new FantIngenPersonException("Fant ingen person for gitt identifikator");
        }

        return null;
    }
}
