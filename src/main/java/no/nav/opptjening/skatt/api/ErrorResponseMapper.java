package no.nav.opptjening.skatt.api;

import no.nav.opptjening.skatt.Feilmelding;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public interface ErrorResponseMapper {

    @NotNull
    Feilmelding mapErrorResponse(@NotNull ResponseBody errorBody);
}
