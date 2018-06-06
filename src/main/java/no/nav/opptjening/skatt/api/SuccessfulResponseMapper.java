package no.nav.opptjening.skatt.api;

import org.jetbrains.annotations.NotNull;

public interface SuccessfulResponseMapper<R, S> {

    @NotNull
    S mapToResponse(@NotNull R response);
}
