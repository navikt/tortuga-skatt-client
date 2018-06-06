package no.nav.opptjening.skatt.client.api;

import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.api.exceptions.ResponseUnmappableException;
import no.nav.opptjening.skatt.client.schema.hendelsesliste.FeilmeldingDto;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DefaultErrorMapperTest {
    private final Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(JacksonConverterFactory.create())
            .baseUrl("http://test")
            .build();

    private final AbstractClient.DefaultErrorMapper responseMapper = new AbstractClient.DefaultErrorMapper(retrofit);

    @Test(expected = ResponseUnmappableException.class)
    public void when_ResponseDoesNotMatchSchema_Then_ThrowUnmappableException() {
        Response<FeilmeldingDto> response = Response.error(404, ResponseBody.create(MediaType.parse("application/json"),
                "{\"feilkode\": \"ZZ-001\", \"feilmelding\": \"Denne feilkoden er ikke implementert\"}"));

        responseMapper.mapErrorResponse(response.errorBody());
    }

    @Test
    public void when_ResponseContainsFeilmelding_Then_ValuesAreMappedCorrectly() {
        Response<FeilmeldingDto> response = Response.error(404, ResponseBody.create(MediaType.parse("application/json"),
                "{\"kode\": \"ZZ-001\", \"melding\": \"Denne feilkoden er ikke implementert\", \"korrelasjonsId\": \"foo\"}"));

        Feilmelding result = responseMapper.mapErrorResponse(response.errorBody());


        Assert.assertEquals("ZZ-001", result.getKode());
        Assert.assertEquals("Denne feilkoden er ikke implementert", result.getMelding());
    }
}
