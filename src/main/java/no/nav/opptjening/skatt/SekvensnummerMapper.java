package no.nav.opptjening.skatt;

import no.nav.opptjening.skatt.schema.hendelsesliste.SekvensnummerDto;
import org.jetbrains.annotations.NotNull;

public class SekvensnummerMapper {
    @NotNull
    public Sekvensnummer mapToSekvensnummer(@NotNull SekvensnummerDto sekvensnummerDto) {
        return new Sekvensnummer(sekvensnummerDto.getSekvensnummer());
    }

}
