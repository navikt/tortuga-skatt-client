package no.nav.opptjening.skatt.client.schema.hendelsesliste;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

public final class FeilmeldingDto {
    private final String kode;
    private final String melding;
    private final String korrelasjonsId;

    @JsonCreator
    public FeilmeldingDto(@JsonProperty("kode") String kode, @JsonProperty("melding") String melding, @JsonProperty("korrelasjonsid") String korrelasjonsId) {
        this.kode = kode;
        this.melding = melding;
        this.korrelasjonsId = korrelasjonsId;
    }

    @Nullable
    public String getKode() {
        return kode;
    }

    @Nullable
    public String getMelding() {
        return melding;
    }

    @Nullable
    public String getKorrelasjonsId() {
        return korrelasjonsId;
    }

    @Override
    public String toString() {
        return "Feilmelding{" +
                "kode='" + kode + '\'' +
                ", melding='" + melding + '\'' +
                ", korrelasjonsId='" + korrelasjonsId + '\'' +
                '}';
    }
}
