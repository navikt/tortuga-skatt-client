package no.nav.opptjening.skatt;

import org.jetbrains.annotations.NotNull;

public final class Feilmelding {
    private final String kode;
    private final String melding;
    private final String korrelasjonsId;

    public Feilmelding(@NotNull String kode, @NotNull String melding, @NotNull String korrelasjonsId) {
        this.kode = kode;
        this.melding = melding;
        this.korrelasjonsId = korrelasjonsId;
    }

    @NotNull
    public String getKode() {
        return kode;
    }

    @NotNull
    public String getMelding() {
        return melding;
    }

    @NotNull
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
