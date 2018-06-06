package no.nav.opptjening.skatt.client.schema.hendelsesliste;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class SekvensnummerDto {
    private final long sekvensnummer;

    @JsonCreator
    public SekvensnummerDto(@JsonProperty("sekvensnummer") long sekvensnummer) {
        this.sekvensnummer = sekvensnummer;
    }

    public long getSekvensnummer() {
        return sekvensnummer;
    }

    @Override
    public String toString() {
        return "Sekvensnummer{" +
                "sekvensnummer=" + sekvensnummer +
                '}';
    }
}
