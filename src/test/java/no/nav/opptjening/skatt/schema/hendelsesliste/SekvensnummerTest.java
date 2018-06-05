package no.nav.opptjening.skatt.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class SekvensnummerTest {

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"sekvensnummer\": 10}";

        Sekvensnummer sekvensnummer = mapper.readValue(jsonString, Sekvensnummer.class);
        Assert.assertEquals(10, sekvensnummer.getSekvensnummer());
    }
}
