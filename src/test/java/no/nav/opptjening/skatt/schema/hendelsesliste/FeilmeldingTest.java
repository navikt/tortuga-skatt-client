package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class FeilmeldingTest {

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"kode\": \"FA-001\", \"melding\": \"fraSekvensnummer må være satt\"}";

        Feilmelding feilmelding = mapper.readValue(jsonString, Feilmelding.class);
        Assert.assertEquals("FA-001", feilmelding.getKode());
        Assert.assertEquals("fraSekvensnummer må være satt", feilmelding.getMelding());
    }
}
