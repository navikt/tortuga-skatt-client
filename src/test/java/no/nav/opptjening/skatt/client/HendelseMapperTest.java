package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.hendelsesliste.HendelseslisteDto;
import org.junit.Assert;
import org.junit.Test;

public class HendelseMapperTest {

    private final HendelseMapper hendelseMapper = new HendelseMapper();

    @Test
    public void that_HendelseDto_is_Mapped() {
        HendelseslisteDto.HendelseDto hendelseDto = new HendelseslisteDto.HendelseDto(1, "123456", "2018");
        Hendelsesliste.Hendelse hendelse = hendelseMapper.mapToHendelse(hendelseDto);

        Assert.assertEquals(1, hendelse.getSekvensnummer());
        Assert.assertEquals("123456", hendelse.getIdentifikator());
        Assert.assertEquals("2018", hendelse.getGjelderPeriode());
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_identifikator_Is_Null() {
        HendelseslisteDto.HendelseDto hendelseDto = new HendelseslisteDto.HendelseDto(1, null, "2018");
        hendelseMapper.mapToHendelse(hendelseDto);
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_gjelderPeriode_Is_Null() {
        HendelseslisteDto.HendelseDto hendelseDto = new HendelseslisteDto.HendelseDto(1, "123456", null);
        hendelseMapper.mapToHendelse(hendelseDto);
    }
}
