package no.nav.opptjening.skatt.client;

import java.util.Objects;

public final class Sekvensnummer {
    private final long sekvensnummer;

    public Sekvensnummer(long sekvensnummer) {
        if (sekvensnummer < 1) {
            throw new IllegalArgumentException("sekvensnummer must be greater than 0");
        }
        this.sekvensnummer = sekvensnummer;
    }

    public long getSekvensnummer() {
        return sekvensnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sekvensnummer that = (Sekvensnummer) o;
        return sekvensnummer == that.sekvensnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sekvensnummer);
    }

    @Override
    public String toString() {
        return "Sekvensnummer{" +
                "sekvensnummer=" + sekvensnummer +
                '}';
    }
}
