package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.BeregnetSkattDto;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BeregnetSkattMapperTest {

    private final BeregnetSkattMapper beregnetSkattMapper = new BeregnetSkattMapper();

    @Test
    public void that_BeregnetSkattDto_is_Mapped_with_all_values() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto("123456", "2018", 1L, 2L, 3L, 4L, 5L, 6L, false);
        BeregnetSkatt beregnetSkatt = beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);

        assertEquals("123456", beregnetSkatt.getPersonidentifikator());
        assertEquals("2018", beregnetSkatt.getInntektsaar());
        assertEquals((Long) 1L, beregnetSkatt.getPersoninntektLoenn().orElse(null));
        assertEquals((Long) 2L, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage().orElse(null));
        assertEquals((Long) 3L, beregnetSkatt.getPersoninntektNaering().orElse(null));
        assertEquals((Long) 4L, beregnetSkatt.getPersoninntektBarePensjonsdel().orElse(null));
        assertEquals((Long) 5L, beregnetSkatt.getSvalbardLoennLoennstrekkordningen().orElse(null));
        assertEquals((Long) 6L, beregnetSkatt.getSvalbardPersoninntektNaering().orElse(null));
        assertFalse(beregnetSkatt.isSkjermet());
    }

    @Test
    public void that_BeregnetSkattDto_is_Mapped_with_missing_inntekter() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto("123456", "2018", 1L, 2L, 3L, 4L, null, null, false);
        BeregnetSkatt beregnetSkatt = beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);

        assertEquals("123456", beregnetSkatt.getPersonidentifikator());
        assertEquals("2018", beregnetSkatt.getInntektsaar());
        assertEquals((Long) 1L, beregnetSkatt.getPersoninntektLoenn().orElse(null));
        assertEquals((Long) 2L, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage().orElse(null));
        assertEquals((Long) 3L, beregnetSkatt.getPersoninntektNaering().orElse(null));
        assertEquals((Long) 4L, beregnetSkatt.getPersoninntektBarePensjonsdel().orElse(null));
        assertNull(beregnetSkatt.getSvalbardLoennLoennstrekkordningen().orElse(null));
        assertNull(beregnetSkatt.getSvalbardPersoninntektNaering().orElse(null));
        assertFalse(beregnetSkatt.isSkjermet());
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_personidentifikator_Is_Null() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto(null, "2018", 1L, 2L, 3L, 4L, 5L, 6L, false);
        beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_inntektsaar_Is_Null() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto("123456", null, 1L, 2L, 3L, 4L, 5L, 6L, false);
        beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);
    }
}
