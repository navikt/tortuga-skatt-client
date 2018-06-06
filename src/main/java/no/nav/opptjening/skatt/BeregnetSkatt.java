package no.nav.opptjening.skatt;

import org.jetbrains.annotations.NotNull;

public final class BeregnetSkatt {

    private final String personidentifikator;
    private final String inntektsaar;
    private final long personinntektLoenn;
    private final long personinntektFiskeFangstFamiliebarnehage;
    private final long personinntektNaering;
    private final long personinntektBarePensjonsdel;
    private final long svalbardLoennLoennstrekkordningen;
    private final long svalbardPersoninntektNaering;
    private final boolean skjermet;

    public BeregnetSkatt(@NotNull String personidentifikator, @NotNull String inntektsaar, long personinntektLoenn, long personinntektFiskeFangstFamiliebarnehage, long personinntektNaering, long personinntektBarePensjonsdel, long svalbardLoennLoennstrekkordningen, long svalbardPersoninntektNaering, boolean skjermet) {
        this.personidentifikator = personidentifikator;
        this.inntektsaar = inntektsaar;
        this.personinntektLoenn = personinntektLoenn;
        this.personinntektFiskeFangstFamiliebarnehage = personinntektFiskeFangstFamiliebarnehage;
        this.personinntektNaering = personinntektNaering;
        this.personinntektBarePensjonsdel = personinntektBarePensjonsdel;
        this.svalbardLoennLoennstrekkordningen = svalbardLoennLoennstrekkordningen;
        this.svalbardPersoninntektNaering = svalbardPersoninntektNaering;
        this.skjermet = skjermet;
    }

    @NotNull
    public String getPersonidentifikator() {
        return personidentifikator;
    }

    @NotNull
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

    public boolean isSkjermet() {
        return skjermet;
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
                ", skjermet=" + skjermet +
                '}';
    }
}
