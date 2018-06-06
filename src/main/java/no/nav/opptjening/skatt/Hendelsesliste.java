package no.nav.opptjening.skatt;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class Hendelsesliste {
    private final List<Hendelse> hendelser;

    public Hendelsesliste(@NotNull List<Hendelse> hendelser) {
        this.hendelser = hendelser;
    }

    @NotNull
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

        public Hendelse(long sekvensnummer, @NotNull String identifikator, @NotNull String gjelderPeriode) {
            if (sekvensnummer < 1) {
                throw new IllegalArgumentException("sekvensnummer must be greater than 0");
            }
            this.sekvensnummer = sekvensnummer;
            this.identifikator = identifikator;
            this.gjelderPeriode = gjelderPeriode;
        }

        public long getSekvensnummer() {
            return sekvensnummer;
        }

        @NotNull
        public String getIdentifikator() {
            return identifikator;
        }

        @NotNull
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
