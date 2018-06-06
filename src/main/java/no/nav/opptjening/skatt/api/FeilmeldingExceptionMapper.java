package no.nav.opptjening.skatt.api;

import no.nav.opptjening.skatt.Feilmelding;
import no.nav.opptjening.skatt.exceptions.HttpException;
import org.jetbrains.annotations.Nullable;

public interface FeilmeldingExceptionMapper {
    @Nullable
    HttpException mapFeilmeldingToHttpException(Feilmelding feilmelding, Throwable cause);
}
