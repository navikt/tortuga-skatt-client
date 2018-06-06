package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.BeregnetSkattDto;
import org.junit.Assert;
import org.junit.Test;

public class BeregnetSkattMapperTest {

    private final BeregnetSkattMapper beregnetSkattMapper = new BeregnetSkattMapper();

    @Test
    public void that_BeregnetSkattDto_is_Mapped() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto("123456", "2018", 1, 2, 3, 4, 5, 6, false);
        BeregnetSkatt beregnetSkatt = beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);

        Assert.assertEquals("123456", beregnetSkatt.getPersonidentifikator());
        Assert.assertEquals("2018", beregnetSkatt.getInntektsaar());
        Assert.assertEquals(1, beregnetSkatt.getPersoninntektLoenn());
        Assert.assertEquals(2, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage());
        Assert.assertEquals(3, beregnetSkatt.getPersoninntektNaering());
        Assert.assertEquals(4, beregnetSkatt.getPersoninntektBarePensjonsdel());
        Assert.assertEquals(5, beregnetSkatt.getSvalbardLoennLoennstrekkordningen());
        Assert.assertEquals(6, beregnetSkatt.getSvalbardPersoninntektNaering());
        Assert.assertFalse(beregnetSkatt.isSkjermet());
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_personidentifikator_Is_Null() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto(null, "2018", 1, 2, 3, 4, 5, 6, false);
        beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_inntektsaar_Is_Null() {
        BeregnetSkattDto beregnetSkattDto = new BeregnetSkattDto("123456", null, 1, 2, 3, 4, 5, 6, false);
        beregnetSkattMapper.mapToBeregnetSkatt(beregnetSkattDto);
    }
}
