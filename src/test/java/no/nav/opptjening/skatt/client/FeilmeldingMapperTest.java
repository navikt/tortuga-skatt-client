package no.nav.opptjening.skatt.client;

import no.nav.opptjening.skatt.client.schema.hendelsesliste.FeilmeldingDto;
import org.junit.Assert;
import org.junit.Test;

public class FeilmeldingMapperTest {
    private final FeilmeldingMapper feilmeldingMapper = new FeilmeldingMapper();

    @Test
    public void that_FeilmeldingDto_is_Mapped() {
        FeilmeldingDto feilmeldingDto = new FeilmeldingDto("DAS-001", "Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!", "foobar");
        Feilmelding feilmelding = feilmeldingMapper.mapToFeilmelding(feilmeldingDto);

        Assert.assertEquals("DAS-001", feilmelding.getKode());
        Assert.assertEquals("Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!", feilmelding.getMelding());
        Assert.assertEquals("foobar", feilmelding.getKorrelasjonsId());
    }

    @Test
    public void that_FeilmeldingDto_is_Mapped_When_korrelasjonsid_Is_Null() {
        FeilmeldingDto feilmeldingDto = new FeilmeldingDto("DAS-001", "Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!", null);
        Feilmelding feilmelding = feilmeldingMapper.mapToFeilmelding(feilmeldingDto);

        Assert.assertEquals("DAS-001", feilmelding.getKode());
        Assert.assertEquals("Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!", feilmelding.getMelding());
        Assert.assertEquals("", feilmelding.getKorrelasjonsId());
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_kode_Is_Null() {
        FeilmeldingDto feilmeldingDto = new FeilmeldingDto(null, "Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!", "foobar");
        feilmeldingMapper.mapToFeilmelding(feilmeldingDto);
    }

    @Test(expected = NullPointerException.class)
    public void that_NPE_When_melding_Is_Null() {
        FeilmeldingDto feilmeldingDto = new FeilmeldingDto("DAS-001", null, "foobar");
        feilmeldingMapper.mapToFeilmelding(feilmeldingDto);
    }
}
