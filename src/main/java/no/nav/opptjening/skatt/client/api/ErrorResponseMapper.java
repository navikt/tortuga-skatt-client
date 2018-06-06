package no.nav.opptjening.skatt.client.api;

import no.nav.opptjening.skatt.client.Feilmelding;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public interface ErrorResponseMapper {

    @NotNull
    Feilmelding mapErrorResponse(@NotNull ResponseBody errorBody);
}
