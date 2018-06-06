package no.nav.opptjening.skatt.api.hendelseliste;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import no.nav.opptjening.skatt.Hendelsesliste;
import no.nav.opptjening.skatt.Sekvensnummer;
import no.nav.opptjening.skatt.api.exceptions.UkjentFeilkodeException;
import no.nav.opptjening.skatt.api.hendelseliste.exceptions.SekvensnummerMåVæreSattException;
import no.nav.opptjening.skatt.api.skatteoppgjoer.SkatteoppgjoerhendelserClient;
import no.nav.opptjening.skatt.exceptions.ClientException;
import no.nav.opptjening.skatt.exceptions.ServerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

public class HendelserClientTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    private HendelserClient hendelserClient;

    @Before
    public void setUp() throws Exception {
        this.hendelserClient = new SkatteoppgjoerhendelserClient("http://localhost:" + wireMockRule.port() + "/", "apikey");
    }

    @Test
    public void when_NextSekvensnummerWithoutDateResponseIsOk_Then_ValuesAreMappedCorrectly() throws Exception {
        String jsonBody = "{\"sekvensnummer\": 10}";

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/start"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.okJson(jsonBody)));

        Sekvensnummer result = hendelserClient.forsteSekvensnummer();

        Assert.assertEquals(10, (long)result.getSekvensnummer());
    }

    @Test
    public void when_NextSekvensnummerAfterDateResponseIsOk_Then_ValuesAreMappedCorrectly() throws Exception {
        String jsonBody = "{\"sekvensnummer\": 10}";

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/start"))
                .withQueryParam("dato", WireMock.equalTo("2017-01-01"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.okJson(jsonBody)));

        LocalDate date = LocalDate.of(2017, 1, 1);
        Sekvensnummer result = hendelserClient.forsteSekvensnummerEtter(date);

        Assert.assertEquals(10, (long)result.getSekvensnummer());
    }

    @Test
    public void when_NextSekvensnummerAfterDateResponseIsGeneric4xxError_Then_ThrowClientException() throws Exception {
        String jsonBody = "{\"sekvensnummer\": 10}";

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/start"))
                .withQueryParam("dato", WireMock.equalTo("2017-01-01"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.badRequest().withBody("this is not valid json").withHeader("Content-type", "application/json")));

        try {
            LocalDate date = LocalDate.of(2017, 1, 1);
            hendelserClient.forsteSekvensnummerEtter(date);
            fail("Expected an ClientException to be thrown");
        } catch (ClientException e) {
            // ok
        }
    }

    @Test
    public void when_HendelserResponseIsOk_Then_ValuesAreMappedCorrectly() throws Exception {
        Map<String, List<HendelseDto>> response = new HashMap<>();

        List<HendelseDto> mockHendelser = new ArrayList<>();
        mockHendelser.add(new HendelseDto(10, "12345", "2016"));
        mockHendelser.add(new HendelseDto(11, "67891", "2017"));

        response.put("hendelser", mockHendelser);

        String jsonBody = new ObjectMapper().writeValueAsString(response);

        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/"))
                .withQueryParam("fraSekvensnummer", WireMock.equalTo("10"))
                .withQueryParam("antall", WireMock.equalTo("1000"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.okJson(jsonBody)));

        Hendelsesliste result = hendelserClient.getHendelser(10, 1000);

        Assert.assertEquals(2, result.getHendelser().size());

        Assert.assertEquals(10, (long)result.getHendelser().get(0).getSekvensnummer());
        Assert.assertEquals("12345", result.getHendelser().get(0).getIdentifikator());
        Assert.assertEquals("2016", result.getHendelser().get(0).getGjelderPeriode());

        Assert.assertEquals(11, (long)result.getHendelser().get(1).getSekvensnummer());
        Assert.assertEquals("67891", result.getHendelser().get(1).getIdentifikator());
        Assert.assertEquals("2017", result.getHendelser().get(1).getGjelderPeriode());
    }

    @Test
    public void when_fraSekvensnummerIsBeyondWhatHasBeenPublished_Then_SkatteetatenRespondsWithEmptyBody_AndWeReturnAnEmptyList() throws Exception {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/"))
                .withQueryParam("fraSekvensnummer", WireMock.equalTo("10"))
                .withQueryParam("antall", WireMock.equalTo("1000"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.okJson("{}")));

        Hendelsesliste result = hendelserClient.getHendelser(10, 1000);

        Assert.assertEquals(0, result.getHendelser().size());
    }

    @Test
    public void when_fraSekvensnummerIsNotSet_Then_ThrowMissingSekvensnummerException() throws Exception {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/"))
                .withQueryParam("fraSekvensnummer", WireMock.equalTo("10"))
                .withQueryParam("antall", WireMock.equalTo("1000"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.badRequest().withHeader("Content-type", "application/json").withBody("{\"kode\": \"FA-001\", \"melding\": \"fraSekvensnummer må være satt\", \"korrelasjonsId\": \"foobar\"}")));

        try {
            hendelserClient.getHendelser(10, 1000);
            fail("Expected an SekvensnummerMåVæreSattException to be thrown");
        } catch (SekvensnummerMåVæreSattException e) {
            // ok
        }
    }

    @Test
    public void when_feilkodeIsUnknown_Then_ThrowUkjentFeilkodeException() throws Exception {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/"))
                .withQueryParam("fraSekvensnummer", WireMock.equalTo("10"))
                .withQueryParam("antall", WireMock.equalTo("1000"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.badRequest().withHeader("Content-type", "application/json").withBody("{\"kode\": \"ZZ-001\", \"melding\": \"Denne feilkoden er ikke implementert\", \"korrelasjonsId\": \"foobar\"}")));

        try {
            hendelserClient.getHendelser(10, 1000);
            fail("Expected an UkjentFeilkodeException to be thrown");
        } catch (UkjentFeilkodeException e) {
            // ok
        }
    }

    @Test
    public void when_HendelserResponseIsGeneric4xxError_Then_ThrowClientException() throws Exception {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/"))
                .withQueryParam("fraSekvensnummer", WireMock.equalTo("10"))
                .withQueryParam("antall", WireMock.equalTo("1000"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.badRequest().withBody("bad request")));

        try {
            hendelserClient.getHendelser(10, 1000);
            fail("Expected an ClientException to be thrown");
        } catch (ClientException e) {
            // ok
        }
    }

    @Test
    public void when_HendelserResponseIsGeneric5xxError_Then_ThrowServerException() throws Exception {
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo("/hendelser/"))
                .withQueryParam("fraSekvensnummer", WireMock.equalTo("10"))
                .withQueryParam("antall", WireMock.equalTo("1000"))
                .withHeader("X-Nav-Apikey", WireMock.equalTo("apikey"))
                .willReturn(WireMock.serverError().withBody("internal server error")));
        try {
            Hendelsesliste result = hendelserClient.getHendelser(10, 1000);
            fail("Expected an ServerException to be thrown");
        } catch (ServerException e) {
            // ok
        }
    }

    private class HendelseDto {
        public final long sekvensnummer;
        public final String identifikator;
        public final String gjelderPeriode;

        public HendelseDto(long sekvensnummer, String identifikator, String gjelderPeriode) {
            this.sekvensnummer = sekvensnummer;
            this.identifikator = identifikator;
            this.gjelderPeriode = gjelderPeriode;
        }
    }
}
