package no.nav.opptjening.skatt.client;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class BeregnetSkatt {

    private final String personidentifikator;
    private final String inntektsaar;
    private final Long personinntektLoenn;
    private final Long personinntektFiskeFangstFamiliebarnehage;
    private final Long personinntektNaering;
    private final Long personinntektBarePensjonsdel;
    private final Long svalbardLoennLoennstrekkordningen;
    private final Long svalbardPersoninntektNaering;
    private final boolean skjermet;

    public BeregnetSkatt(@NotNull String personidentifikator, @NotNull String inntektsaar, Long personinntektLoenn, Long personinntektFiskeFangstFamiliebarnehage, Long personinntektNaering, Long personinntektBarePensjonsdel, Long svalbardLoennLoennstrekkordningen, Long svalbardPersoninntektNaering, boolean skjermet) {
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

    public Long getPersoninntektLoenn() {
        return personinntektLoenn;
    }

    public Long getPersoninntektFiskeFangstFamiliebarnehage() {
        return personinntektFiskeFangstFamiliebarnehage;
    }

    public Long getPersoninntektNaering() {
        return personinntektNaering;
    }

    public Long getPersoninntektBarePensjonsdel() {
        return personinntektBarePensjonsdel;
    }

    public Long getSvalbardLoennLoennstrekkordningen() {
        return svalbardLoennLoennstrekkordningen;
    }

    public Long getSvalbardPersoninntektNaering() {
        return svalbardPersoninntektNaering;
    }

    public boolean isSkjermet() {
        return skjermet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeregnetSkatt that = (BeregnetSkatt) o;
        return personinntektLoenn == that.personinntektLoenn &&
                personinntektFiskeFangstFamiliebarnehage == that.personinntektFiskeFangstFamiliebarnehage &&
                personinntektNaering == that.personinntektNaering &&
                personinntektBarePensjonsdel == that.personinntektBarePensjonsdel &&
                svalbardLoennLoennstrekkordningen == that.svalbardLoennLoennstrekkordningen &&
                svalbardPersoninntektNaering == that.svalbardPersoninntektNaering &&
                skjermet == that.skjermet &&
                Objects.equals(personidentifikator, that.personidentifikator) &&
                Objects.equals(inntektsaar, that.inntektsaar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personidentifikator, inntektsaar, personinntektLoenn,
                personinntektFiskeFangstFamiliebarnehage, personinntektNaering, personinntektBarePensjonsdel,
                svalbardLoennLoennstrekkordningen, svalbardPersoninntektNaering, skjermet);
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
