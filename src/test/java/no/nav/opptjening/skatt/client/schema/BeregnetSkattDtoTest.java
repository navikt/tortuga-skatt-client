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
        assertNull(beregnetSkatt.getPersoninntektLoenn().orElse(null));
        assertNull(beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage().orElse(null));
        assertNull(beregnetSkatt.getPersoninntektNaering().orElse(null));
        assertNull(beregnetSkatt.getPersoninntektBarePensjonsdel().orElse(null));
        assertNull(beregnetSkatt.getSvalbardLoennLoennstrekkordningen().orElse(null));
        assertNull(beregnetSkatt.getSvalbardPersoninntektNaering().orElse(null));
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
        assertEquals((Long) 490000L, beregnetSkatt.getPersoninntektLoenn().orElse(null));
        assertEquals((Long) 90000L, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage().orElse(null));
        assertEquals((Long) 70000L, beregnetSkatt.getPersoninntektNaering().orElse(null));
        assertEquals((Long) 40000L, beregnetSkatt.getPersoninntektBarePensjonsdel().orElse(null));
        assertEquals((Long) 123456L, beregnetSkatt.getSvalbardLoennLoennstrekkordningen().orElse(null));
        assertEquals((Long) 654321L, beregnetSkatt.getSvalbardPersoninntektNaering().orElse(null));
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
        assertEquals((Long) 490000L, beregnetSkatt.getPersoninntektLoenn().orElse(null));
        assertEquals((Long) 90000L, beregnetSkatt.getPersoninntektFiskeFangstFamiliebarnehage().orElse(null));
        assertNull(beregnetSkatt.getPersoninntektNaering().orElse(null));
        assertNull(beregnetSkatt.getPersoninntektBarePensjonsdel().orElse(null));
        assertNull(beregnetSkatt.getSvalbardLoennLoennstrekkordningen().orElse(null));
        assertNull(beregnetSkatt.getSvalbardPersoninntektNaering().orElse(null));
    }
}
