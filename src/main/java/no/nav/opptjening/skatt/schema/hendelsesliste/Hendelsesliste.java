package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

public final class Hendelsesliste {
    private final List<Hendelse> hendelser;

    @JsonCreator
    public Hendelsesliste(@JsonProperty("hendelse") List<Hendelse> hendelser) {
        this.hendelser = hendelser != null ? hendelser : Collections.EMPTY_LIST;
    }

    public List<Hendelse> getHendelser() {
        return hendelser;
    }

    @Override
    public String toString() {
        return "Hendelsesliste{" +
                "hendelser=" + hendelser +
                '}';
    }

    public static final class Hendelse {
        private final long sekvensnummer;
        private final String identifikator;
        private final String gjelderPeriode;

        @JsonCreator
        public Hendelse(@JsonProperty("sekvensnummer") long sekvensnummer, @JsonProperty("identifikator") String identifikator, @JsonProperty("gjelderPeriode") String gjelderPeriode) {
            this.sekvensnummer = sekvensnummer;
            this.identifikator = identifikator;
            this.gjelderPeriode = gjelderPeriode;
        }

        public long getSekvensnummer() {
            return sekvensnummer;
        }

        public String getIdentifikator() {
            return identifikator;
        }

        public String getGjelderPeriode() {
            return gjelderPeriode;
        }

        @Override
        public String toString() {
            return "Hendelse{" +
                    "sekvensnummer=" + sekvensnummer +
                    ", identifikator='" + identifikator + '\'' +
                    ", gjelderPeriode='" + gjelderPeriode + '\'' +
                    '}';
        }
    }
}
