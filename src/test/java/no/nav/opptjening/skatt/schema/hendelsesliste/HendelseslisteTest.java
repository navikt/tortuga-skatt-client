package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class HendelseslisteTest {

    @Test
    public void that_Mapping_Works_With_No_Body() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{}";

        Hendelsesliste hendelsesliste = mapper.readValue(jsonString, Hendelsesliste.class);

        Assert.assertNotNull(hendelsesliste.getHendelser());
        Assert.assertEquals(0, hendelsesliste.getHendelser().size());
    }

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\n" +
                "    \"hendelse\": [\n" +
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

        Hendelsesliste hendelsesliste = mapper.readValue(jsonString, Hendelsesliste.class);
        Assert.assertEquals(5, hendelsesliste.getHendelser().size());

        Hendelsesliste.Hendelse hendelse = hendelsesliste.getHendelser().get(0);
        Assert.assertEquals(1, hendelse.getSekvensnummer());
        Assert.assertEquals("09048000875", hendelse.getIdentifikator());
        Assert.assertEquals("2015", hendelse.getGjelderPeriode());

        hendelse = hendelsesliste.getHendelser().get(1);
        Assert.assertEquals(2, hendelse.getSekvensnummer());
        Assert.assertEquals("20125001158", hendelse.getIdentifikator());
        Assert.assertEquals("2015", hendelse.getGjelderPeriode());

        hendelse = hendelsesliste.getHendelser().get(2);
        Assert.assertEquals(3, hendelse.getSekvensnummer());
        Assert.assertEquals("02043700564", hendelse.getIdentifikator());
        Assert.assertEquals("2015", hendelse.getGjelderPeriode());

        hendelse = hendelsesliste.getHendelser().get(3);
        Assert.assertEquals(4, hendelse.getSekvensnummer());
        Assert.assertEquals("17014200150", hendelse.getIdentifikator());
        Assert.assertEquals("2015", hendelse.getGjelderPeriode());

        hendelse = hendelsesliste.getHendelser().get(4);
        Assert.assertEquals(5, hendelse.getSekvensnummer());
        Assert.assertEquals("17055401993", hendelse.getIdentifikator());
        Assert.assertEquals("2015", hendelse.getGjelderPeriode());
    }
}
