package no.nav.opptjening.skatt.schema;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = BeregnetSkatt.Builder.class)
public final class BeregnetSkatt {

    private final String personidentifikator;
    private final String inntektsaar;
    private final long personinntektLoenn;
    private final long personinntektFiskeFangstFamiliebarnehage;
    private final long personinntektNaering;
    private final long personinntektBarePensjonsdel;
    private final long svalbardLoennLoennstrekkordningen;
    private final long svalbardPersoninntektNaering;

    public BeregnetSkatt(String personidentifikator, String inntektsaar, long personinntektLoenn, long personinntektFiskeFangstFamiliebarnehage, long personinntektNaering, long personinntektBarePensjonsdel, long svalbardLoennLoennstrekkordningen, long svalbardPersoninntektNaering) {
        this.personidentifikator = personidentifikator;
        this.inntektsaar = inntektsaar;
        this.personinntektLoenn = personinntektLoenn;
        this.personinntektFiskeFangstFamiliebarnehage = personinntektFiskeFangstFamiliebarnehage;
        this.personinntektNaering = personinntektNaering;
        this.personinntektBarePensjonsdel = personinntektBarePensjonsdel;
        this.svalbardLoennLoennstrekkordningen = svalbardLoennLoennstrekkordningen;
        this.svalbardPersoninntektNaering = svalbardPersoninntektNaering;
    }

    public String getPersonidentifikator() {
        return personidentifikator;
    }

    public String getInntektsaar() {
        return inntektsaar;
    }

    public long getPersoninntektLoenn() {
        return personinntektLoenn;
    }

    public long getPersoninntektFiskeFangstFamiliebarnehage() {
        return personinntektFiskeFangstFamiliebarnehage;
    }

    public long getPersoninntektNaering() {
        return personinntektNaering;
    }

    public long getPersoninntektBarePensjonsdel() {
        return personinntektBarePensjonsdel;
    }

    public long getSvalbardLoennLoennstrekkordningen() {
        return svalbardLoennLoennstrekkordningen;
    }

    public long getSvalbardPersoninntektNaering() {
        return svalbardPersoninntektNaering;
    }

    @Override
    public String toString() {
        return "BeregnetSkatt{" +
                "personidentifikator='" + personidentifikator + '\'' +
                ", inntektsaar='" + inntektsaar + '\'' +
                ", personinntektLoenn=" + personinntektLoenn +
                ", personinntektFiskeFangstFamiliebarnehage=" + personinntektFiskeFangstFamiliebarnehage +
                ", personinntektNaering=" + personinntektNaering +
                ", personinntektBarePensjonsdel=" + personinntektBarePensjonsdel +
                ", svalbardLoennLoennstrekkordningen=" + svalbardLoennLoennstrekkordningen +
                ", svalbardPersoninntektNaering=" + svalbardPersoninntektNaering +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String personidentifikator;
        private String inntektsaar;
        private long personinntektLoenn;
        private long personinntektFiskeFangstFamiliebarnehage;
        private long personinntektNaering;
        private long personinntektBarePensjonsdel;
        private long svalbardLoennLoennstrekkordningen;
        private long svalbardPersoninntektNaering;

        private Builder() {
        }

        public Builder withPersonidentifikator(String personidentifikator) {
            this.personidentifikator = personidentifikator;
            return this;
        }

        public Builder withInntektsaar(String inntektsaar) {
            this.inntektsaar = inntektsaar;
            return this;
        }

        public Builder withPersoninntektLoenn(long personinntektLoenn) {
            this.personinntektLoenn = personinntektLoenn;
            return this;
        }

        public Builder withPersoninntektFiskeFangstFamiliebarnehage(long personinntektFiskeFangstFamiliebarnehage) {
            this.personinntektFiskeFangstFamiliebarnehage = personinntektFiskeFangstFamiliebarnehage;
            return this;
        }

        public Builder withPersoninntektNaering(long personinntektNaering) {
            this.personinntektNaering = personinntektNaering;
            return this;
        }

        public Builder withPersoninntektBarePensjonsdel(long personinntektBarePensjonsdel) {
            this.personinntektBarePensjonsdel = personinntektBarePensjonsdel;
            return this;
        }

        public Builder withSvalbardLoennLoennstrekkordningen(long svalbardLoennLoennstrekkordningen) {
            this.svalbardLoennLoennstrekkordningen = svalbardLoennLoennstrekkordningen;
            return this;
        }

        public Builder withSvalbardPersoninntektNaering(long svalbardPersoninntektNaering) {
            this.svalbardPersoninntektNaering = svalbardPersoninntektNaering;
            return this;
        }

        public BeregnetSkatt build() {
            return new BeregnetSkatt(personidentifikator, inntektsaar, personinntektLoenn, personinntektFiskeFangstFamiliebarnehage, personinntektNaering, personinntektBarePensjonsdel, svalbardLoennLoennstrekkordningen, svalbardPersoninntektNaering);
        }
    }
}
