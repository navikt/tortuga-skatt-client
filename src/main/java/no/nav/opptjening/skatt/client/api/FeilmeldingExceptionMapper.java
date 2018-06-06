package no.nav.opptjening.skatt.client.api;

import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FeilmeldingExceptionMapper {
    @Nullable
    HttpException mapFeilmeldingToHttpException(@NotNull Feilmelding feilmelding);
}
