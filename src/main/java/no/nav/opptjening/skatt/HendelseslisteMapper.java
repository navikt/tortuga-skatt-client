package no.nav.opptjening.skatt;

import no.nav.opptjening.skatt.schema.hendelsesliste.HendelseslisteDto;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HendelseslisteMapper {
    private final HendelseMapper hendelseMapper = new HendelseMapper();

    @NotNull
    public Hendelsesliste mapToHendelsesliste(@NotNull HendelseslisteDto hendelseslisteDto) {
        List<HendelseslisteDto.HendelseDto> hendelser = hendelseslisteDto.getHendelser();
        if (hendelser == null) {
            hendelser = Collections.emptyList();
        }
        return new Hendelsesliste(hendelser.stream()
                .map(hendelseMapper::mapToHendelse)
                .collect(Collectors.toList()));
    }
}
