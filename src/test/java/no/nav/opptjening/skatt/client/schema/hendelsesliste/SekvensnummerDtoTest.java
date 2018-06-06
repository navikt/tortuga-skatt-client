package no.nav.opptjening.skatt.client.schema.hendelsesliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

public class SekvensnummerDtoTest {

    @Test
    public void that_Mapping_Works() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"sekvensnummer\": 10}";

        SekvensnummerDto sekvensnummer = mapper.readValue(jsonString, SekvensnummerDto.class);
        Assert.assertEquals(10, sekvensnummer.getSekvensnummer());
    }
}
