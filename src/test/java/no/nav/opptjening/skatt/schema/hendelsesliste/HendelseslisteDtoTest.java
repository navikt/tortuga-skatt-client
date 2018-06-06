package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class HendelseslisteDtoTest {

    @Test
    public void that_Mapping_Works_With_No_Body() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{}";

        HendelseslisteDto hendelsesliste = mapper.readValue(jsonString, HendelseslisteDto.class);
        Assert.assertNull(hendelsesliste.getHendelser());
    }

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"hendelser\": [\n" +
                "        {\n" +
                "            \"sekvensnummer\": 1,\n" +
                "            \"identifikator\": \"09048000875\",\n" +
                "            \"gjelderPeriode\": \"2015\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sekvensnummer\": 2,\n" +
                "            \"identifikator\": \"20125001158\",\n" +
                "            \"gjelderPeriode\": \"2015\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sekvensnummer\": 3,\n" +
                "            \"identifikator\": \"02043700564\",\n" +
                "            \"gjelderPeriode\": \"2015\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sekvensnummer\": 4,\n" +
                "            \"identifikator\": \"17014200150\",\n" +
                "            \"gjelderPeriode\": \"2015\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"sekvensnummer\": 5,\n" +
                "            \"identifikator\": \"17055401993\",\n" +
                "            \"gjelderPeriode\": \"2015\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "\n";

        HendelseslisteDto hendelsesliste = mapper.readValue(jsonString, HendelseslisteDto.class);
        Assert.assertEquals(5, hendelsesliste.getHendelser().size());

        HendelseslisteDto.HendelseDto hendelseDto = hendelsesliste.getHendelser().get(0);
        Assert.assertEquals(1, hendelseDto.getSekvensnummer());
        Assert.assertEquals("09048000875", hendelseDto.getIdentifikator());
        Assert.assertEquals("2015", hendelseDto.getGjelderPeriode());

        hendelseDto = hendelsesliste.getHendelser().get(1);
        Assert.assertEquals(2, hendelseDto.getSekvensnummer());
        Assert.assertEquals("20125001158", hendelseDto.getIdentifikator());
        Assert.assertEquals("2015", hendelseDto.getGjelderPeriode());

        hendelseDto = hendelsesliste.getHendelser().get(2);
        Assert.assertEquals(3, hendelseDto.getSekvensnummer());
        Assert.assertEquals("02043700564", hendelseDto.getIdentifikator());
        Assert.assertEquals("2015", hendelseDto.getGjelderPeriode());

        hendelseDto = hendelsesliste.getHendelser().get(3);
        Assert.assertEquals(4, hendelseDto.getSekvensnummer());
        Assert.assertEquals("17014200150", hendelseDto.getIdentifikator());
        Assert.assertEquals("2015", hendelseDto.getGjelderPeriode());

        hendelseDto = hendelsesliste.getHendelser().get(4);
        Assert.assertEquals(5, hendelseDto.getSekvensnummer());
        Assert.assertEquals("17055401993", hendelseDto.getIdentifikator());
        Assert.assertEquals("2015", hendelseDto.getGjelderPeriode());
    }
}
