package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class FeilmeldingTest {

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"kode\": \"FA-001\", \"melding\": \"fraSekvensnummer må være satt\", \"korrelasjonsid\": \"52e3ce7eb8df80fa6a135dc6eae475f6\"}";

        Feilmelding feilmelding = mapper.readValue(jsonString, Feilmelding.class);
        Assert.assertEquals("FA-001", feilmelding.getKode());
        Assert.assertEquals("fraSekvensnummer må være satt", feilmelding.getMelding());
        Assert.assertEquals("52e3ce7eb8df80fa6a135dc6eae475f6", feilmelding.getKorrelasjonsId());
    }
}
