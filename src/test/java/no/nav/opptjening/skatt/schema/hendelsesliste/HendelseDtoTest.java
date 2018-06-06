package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class HendelseDtoTest {

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
            "    \"sekvensnummer\": 1,\n" +
            "    \"identifikator\": \"09048000875\",\n" +
            "    \"gjelderPeriode\": \"2015\"\n" +
            "}";

        HendelseslisteDto.HendelseDto hendelseDto = mapper.readValue(jsonString, HendelseslisteDto.HendelseDto.class);
        Assert.assertEquals(1, hendelseDto.getSekvensnummer());
        Assert.assertEquals("09048000875", hendelseDto.getIdentifikator());
        Assert.assertEquals("2015", hendelseDto.getGjelderPeriode());
    }
}
