package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.hendelsesliste.HendelseslisteDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HendelseslisteMapperTest {
    private final HendelseslisteMapper hendelseslisteMapper = new HendelseslisteMapper();

    @Test
    public void that_HendelseslisteDto_is_Mapped() {
        HendelseslisteDto hendelseslisteDto = new HendelseslisteDto(Arrays.asList(new HendelseslisteDto.HendelseDto(1, "123456", "2018"),
                new HendelseslisteDto.HendelseDto(2, "654321", "2018")));
        Hendelsesliste hendelsesliste = hendelseslisteMapper.mapToHendelsesliste(hendelseslisteDto);

        List<Hendelsesliste.Hendelse> hendelser = hendelsesliste.getHendelser();
        Assert.assertEquals(2, hendelser.size());

        Hendelsesliste.Hendelse hendelse = hendelser.get(0);
        Assert.assertEquals(1, hendelse.getSekvensnummer());
        Assert.assertEquals("123456", hendelse.getIdentifikator());
        Assert.assertEquals("2018", hendelse.getGjelderPeriode());

        hendelse = hendelser.get(1);
        Assert.assertEquals(2, hendelse.getSekvensnummer());
        Assert.assertEquals("654321", hendelse.getIdentifikator());
        Assert.assertEquals("2018", hendelse.getGjelderPeriode());
    }
}
