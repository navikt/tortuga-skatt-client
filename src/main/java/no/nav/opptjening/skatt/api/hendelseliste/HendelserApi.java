package no.nav.opptjening.skatt.api.hendelseliste;

import no.nav.opptjening.skatt.schema.hendelsesliste.HendelseslisteDto;
import no.nav.opptjening.skatt.schema.hendelsesliste.SekvensnummerDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDate;

public interface HendelserApi {

    @GET("hendelser/start")
    Call<SekvensnummerDto> forsteSekvensnummerEtter(@Query("dato") LocalDate dato);

    @GET("hendelser/start")
    Call<SekvensnummerDto> forsteSekvensnummer();

    @GET("hendelser/")
    Call<HendelseslisteDto> getHendelser(@Query("fraSekvensnummer") long fraSekvensnummer, @Query("antall") int antall);
}

