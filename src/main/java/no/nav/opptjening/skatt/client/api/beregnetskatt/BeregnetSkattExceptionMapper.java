package no.nav.opptjening.skatt.client.api.beregnetskatt;

import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.api.FeilmeldingExceptionMapper;
import no.nav.opptjening.skatt.client.api.beregnetskatt.exceptions.*;
import no.nav.opptjening.skatt.client.exceptions.HttpException;

public class BeregnetSkattExceptionMapper implements FeilmeldingExceptionMapper {
    public HttpException mapFeilmeldingToHttpException(Feilmelding feilmelding, Throwable cause) {
        switch (feilmelding.getKode()) {
            case "BSA-005":
                return new InntektsåretErIkkeStøttetException("Det forespurte inntektsåret er ikke støttet", cause);
            case "BSA-006":
                return new FantIkkeBeregnetSkattException("Fant ikke Beregnet Skatt for gitt inntektsår og identifikator", cause);
            case "BSA-007":
                return new UgyldigInntektsårException("Inntektsår har ikke gyldig format", cause);
            case "BSA-008":
                return new UgyldigPersonidentifikator("Personidentifikator har ikke gyldig format", cause);
            case "BSA-009":
                return new FantIngenPersonException("Fant ingen person for gitt identifikator", cause);
        }

        return null;
    }
}
