package no.nav.opptjening.skatt;

import no.nav.opptjening.skatt.schema.BeregnetSkattDto;
import org.jetbrains.annotations.NotNull;

public class BeregnetSkattMapper {

    @NotNull
    public BeregnetSkatt mapToBeregnetSkatt(@NotNull BeregnetSkattDto beregnetSkattDto) {
        String personidentifikator = beregnetSkattDto.getPersonidentifikator();
        String inntektsaar = beregnetSkattDto.getInntektsaar();
        if (personidentifikator == null) {
            throw new NullPointerException("Personidentifikator is null");
        }
        if (inntektsaar == null) {
            throw new NullPointerException("Inntektsaar is null");
        }
        return new BeregnetSkatt(personidentifikator, inntektsaar, beregnetSkattDto.getPersoninntektLoenn(),
                beregnetSkattDto.getPersoninntektFiskeFangstFamiliebarnehage(), beregnetSkattDto.getPersoninntektNaering(),
                beregnetSkattDto.getPersoninntektBarePensjonsdel(), beregnetSkattDto.getSvalbardLoennLoennstrekkordningen(),
                beregnetSkattDto.getSvalbardPersoninntektNaering(), beregnetSkattDto.isSkjermet());
    }
}
