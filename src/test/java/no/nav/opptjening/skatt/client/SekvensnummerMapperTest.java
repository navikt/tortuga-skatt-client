package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.hendelsesliste.SekvensnummerDto;
import org.junit.Assert;
import org.junit.Test;

public class SekvensnummerMapperTest {

    private final SekvensnummerMapper sekvensnummerMapper = new SekvensnummerMapper();

    @Test
    public void that_SekvensnummerDto_is_Mapped() {
        SekvensnummerDto sekvensnummerDto = new SekvensnummerDto(1);
        Sekvensnummer sekvensnummer = sekvensnummerMapper.mapToSekvensnummer(sekvensnummerDto);

        Assert.assertEquals(1, sekvensnummer.getSekvensnummer());
    }
}
