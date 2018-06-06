package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.hendelsesliste.HendelseslisteDto;
import org.jetbrains.annotations.NotNull;

public class HendelseMapper {
    @NotNull
    public Hendelsesliste.Hendelse mapToHendelse(@NotNull HendelseslisteDto.HendelseDto hendelseDto) {
        String identifikator = hendelseDto.getIdentifikator();
        String gjelderPeriode = hendelseDto.getGjelderPeriode();

        if (identifikator == null) {
            throw new NullPointerException("identifikator is null");
        }
        if (gjelderPeriode == null) {
            throw new NullPointerException("gjelderPeriode is null");
        }

        return new Hendelsesliste.Hendelse(hendelseDto.getSekvensnummer(),
                hendelseDto.getIdentifikator(), hendelseDto.getGjelderPeriode());
    }
}
