package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Feilmelding {
    private final String kode;
    private final String melding;

    @JsonCreator
    public Feilmelding(@JsonProperty("kode") String kode, @JsonProperty("melding") String melding) {
        this.kode = kode;
        this.melding = melding;
    }

    public String getKode() {
        return kode;
    }

    public String getMelding() {
        return melding;
    }

    @Override
    public String toString() {
        return "Feilmelding{" +
                "kode='" + kode + '\'' +
                ", melding='" + melding + '\'' +
                '}';
    }
}
