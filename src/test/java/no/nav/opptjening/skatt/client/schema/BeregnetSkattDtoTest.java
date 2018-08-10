package no.nav.opptjening.skatt.client.schema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BeregnetSkattDtoTest {

    @Test
    public void that_Mapping_Works_With_Default_Values() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"personidentifikator\": \"12345678901\",\n" +
                "    \"inntektsaar\": \"2016\"\n" +
                "}\n";

        BeregnetSkattDto beregnetSkatt = mapper.readValue(jsonString, BeregnetSkattDto.class);
        assertEquals("12345678901", beregnetSkatt.getPersonidentifikator());
        assertEquals("2016", beregnetSkatt.getInntektsaar());
        assertNull(beregnetSkatt.getPersoninntektLoenn());
        assertNull(beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage());
        assertNull(beregnetSkatt.getPersoninntektNaering());
        assertNull(beregnetSkatt.getPersoninntektBarePensjonsdel());
        assertNull(beregnetSkatt.getSvalbardLoennLoennstrekkordningen());
        assertNull(beregnetSkatt.getSvalbardPersoninntektNaering());
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

        BeregnetSkattDto beregnetSkatt = mapper.readValue(jsonString, BeregnetSkattDto.class);
        assertEquals("12345678901", beregnetSkatt.getPersonidentifikator());
        assertEquals("2016", beregnetSkatt.getInntektsaar());
        assertEquals(490000, (long) beregnetSkatt.getPersoninntektLoenn());
        assertEquals(90000, (long) beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage());
        assertEquals(70000, (long) beregnetSkatt.getPersoninntektNaering());
        assertEquals(40000, (long) beregnetSkatt.getPersoninntektBarePensjonsdel());
        assertEquals(123456, (long) beregnetSkatt.getSvalbardLoennLoennstrekkordningen());
        assertEquals(654321, (long) beregnetSkatt.getSvalbardPersoninntektNaering());
    }

    @Test
    public void that_Mapping_Works_With_Some_Null_And_Some_Long_Values() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"personidentifikator\": \"12345678901\",\n" +
                "    \"inntektsaar\": \"2016\",\n" +
                "    \"personinntektLoenn\": 490000,\n" +
                "    \"personinntektFiskeFangstFamiliebarnehage\": 90000,\n" +
                "    \"skjermet\": false\n" +
                "}\n";

        BeregnetSkattDto beregnetSkatt = mapper.readValue(jsonString, BeregnetSkattDto.class);
        assertEquals("12345678901", beregnetSkatt.getPersonidentifikator());
        assertEquals("2016", beregnetSkatt.getInntektsaar());
        assertEquals(490000, (long) beregnetSkatt.getPersoninntektLoenn());
        assertEquals(90000, (long) beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage());
        assertNull(beregnetSkatt.getPersoninntektNaering());
        assertNull(beregnetSkatt.getPersoninntektBarePensjonsdel());
        assertNull(beregnetSkatt.getSvalbardLoennLoennstrekkordningen());
        assertNull(beregnetSkatt.getSvalbardPersoninntektNaering());
    }
}
