package no.nav.opptjening.skatt.schema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class BeregnetSkattTest {

    @Test
    public void that_Mapping_Works_With_Default_Values() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"personidentifikator\": \"12345678901\",\n" +
                "    \"inntektsaar\": \"2016\"\n" +
                "}\n";

        BeregnetSkatt beregnetSkatt = mapper.readValue(jsonString, BeregnetSkatt.class);
        Assert.assertEquals("12345678901", beregnetSkatt.getPersonidentifikator());
        Assert.assertEquals("2016", beregnetSkatt.getInntektsaar());
        Assert.assertEquals(0, beregnetSkatt.getPersoninntektLoenn());
        Assert.assertEquals(0, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage());
        Assert.assertEquals(0, beregnetSkatt.getPersoninntektNaering());
        Assert.assertEquals(0, beregnetSkatt.getPersoninntektBarePensjonsdel());
        Assert.assertEquals(0, beregnetSkatt.getSvalbardLoennLoennstrekkordningen());
        Assert.assertEquals(0, beregnetSkatt.getSvalbardPersoninntektNaering());
    }

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"personidentifikator\": \"12345678901\",\n" +
                "    \"inntektsaar\": \"2016\",\n" +
                "    \"personinntektLoenn\": 490000,\n" +
                "    \"personinntektFiskeFangstFamiliebarnehage\": 90000,\n" +
                "    \"personinntektNaering\": 70000,\n" +
                "    \"personinntektBarePensjonsdel\": 40000,\n" +
                "    \"svalbardLoennLoennstrekkordningen\": 123456,\n" +
                "    \"svalbardPersoninntektNaering\": 654321," +
                "    \"skjermet\": false\n" +
                "}\n";

        BeregnetSkatt beregnetSkatt = mapper.readValue(jsonString, BeregnetSkatt.class);
        Assert.assertEquals("12345678901", beregnetSkatt.getPersonidentifikator());
        Assert.assertEquals("2016", beregnetSkatt.getInntektsaar());
        Assert.assertEquals(490000, beregnetSkatt.getPersoninntektLoenn());
        Assert.assertEquals(90000, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage());
        Assert.assertEquals(70000, beregnetSkatt.getPersoninntektNaering());
        Assert.assertEquals(40000, beregnetSkatt.getPersoninntektBarePensjonsdel());
        Assert.assertEquals(123456, beregnetSkatt.getSvalbardLoennLoennstrekkordningen());
        Assert.assertEquals(654321, beregnetSkatt.getSvalbardPersoninntektNaering());
    }
}
