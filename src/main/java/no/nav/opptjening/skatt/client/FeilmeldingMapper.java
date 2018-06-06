package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.hendelsesliste.FeilmeldingDto;
import org.jetbrains.annotations.NotNull;

public class FeilmeldingMapper {
    @NotNull
    public Feilmelding mapToFeilmelding(@NotNull FeilmeldingDto feilmeldingDto) {
        String kode = feilmeldingDto.getKode();
        String melding = feilmeldingDto.getMelding();
        String korrelasjonsId = feilmeldingDto.getKorrelasjonsId();
        if (kode == null) {
            throw new NullPointerException("Kode is null");
        }
        if (melding == null) {
            throw new NullPointerException("Melding is null");
        }
        if (korrelasjonsId == null) {
            korrelasjonsId = "";
        }
        return new Feilmelding(kode, melding, korrelasjonsId);
    }
}
