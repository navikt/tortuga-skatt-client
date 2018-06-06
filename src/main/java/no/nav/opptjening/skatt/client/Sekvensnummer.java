package no.nav.opptjening.skatt.client;

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
    public String toString() {
        return "Sekvensnummer{" +
                "sekvensnummer=" + sekvensnummer +
                '}';
    }
}
