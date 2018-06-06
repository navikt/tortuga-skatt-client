package no.nav.opptjening.skatt.client.api.hendelseliste;

import no.nav.opptjening.skatt.client.Hendelsesliste;
import no.nav.opptjening.skatt.client.HendelseslisteMapper;
import no.nav.opptjening.skatt.client.Sekvensnummer;
import no.nav.opptjening.skatt.client.SekvensnummerMapper;
import no.nav.opptjening.skatt.client.api.AbstractClient;
import no.nav.opptjening.skatt.client.schema.hendelsesliste.HendelseslisteDto;
import no.nav.opptjening.skatt.client.schema.hendelsesliste.SekvensnummerDto;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

import java.io.IOException;
import java.time.LocalDate;

public abstract class HendelserClient extends AbstractClient<HendelserApi> {

    public HendelserClient(String endepunkt, String apiKey) {
        super(endepunkt, apiKey, HendelserApi.class);
    }

    @NotNull
    public Sekvensnummer forsteSekvensnummerEtter(@NotNull LocalDate dato) throws IOException {
        Call<SekvensnummerDto> request = getApi().forsteSekvensnummerEtter(dato);
        return executeRequest(request, response -> new SekvensnummerMapper().mapToSekvensnummer(response), new HendelselisteExceptionMapper());
    }

    @NotNull
    public Sekvensnummer forsteSekvensnummer() throws IOException {
        Call<SekvensnummerDto> request = getApi().forsteSekvensnummer();
        return executeRequest(request, response -> new SekvensnummerMapper().mapToSekvensnummer(response), new HendelselisteExceptionMapper());
    }

    public Hendelsesliste getHendelser(long fraSekvensnummer, int antall) throws IOException {
        Call<HendelseslisteDto> request = getApi().getHendelser(fraSekvensnummer, antall);
        return executeRequest(request, response -> new HendelseslisteMapper().mapToHendelsesliste(response), new HendelselisteExceptionMapper());
    }
}
