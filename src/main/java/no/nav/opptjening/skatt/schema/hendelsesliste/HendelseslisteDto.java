package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class HendelseslisteDto {
    private final List<HendelseDto> hendelser;

    @JsonCreator
    public HendelseslisteDto(@JsonProperty("hendelser") List<HendelseDto> hendelser) {
        this.hendelser = hendelser;
    }

    @Nullable
    public List<HendelseDto> getHendelser() {
        return hendelser;
    }

    @Override
    public String toString() {
        return "Hendelsesliste{" +
                "hendelser=" + hendelser +
                '}';
    }

    public static final class HendelseDto {
        private final long sekvensnummer;
        private final String identifikator;
        private final String gjelderPeriode;

        @JsonCreator
        public HendelseDto(@JsonProperty("sekvensnummer") long sekvensnummer, @JsonProperty("identifikator") String identifikator, @JsonProperty("gjelderPeriode") String gjelderPeriode) {
            this.sekvensnummer = sekvensnummer;
            this.identifikator = identifikator;
            this.gjelderPeriode = gjelderPeriode;
        }

        public long getSekvensnummer() {
            return sekvensnummer;
        }

        @Nullable
        public String getIdentifikator() {
            return identifikator;
        }

        @Nullable
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
