package no.nav.opptjening.skatt.client.api.beregnetskatt;

import no.nav.opptjening.skatt.client.BeregnetSkatt;
import no.nav.opptjening.skatt.client.BeregnetSkattMapper;
import no.nav.opptjening.skatt.client.api.AbstractClient;
import no.nav.opptjening.skatt.client.schema.BeregnetSkattDto;
import retrofit2.Call;

import java.io.IOException;

public class BeregnetSkattClient extends AbstractClient<BeregnetSkattApi> {

    public BeregnetSkattClient(String endepunkt, String apiKey) {
        super(endepunkt, apiKey, BeregnetSkattApi.class);
    }

    public BeregnetSkatt getBeregnetSkatt(String rettighetspakke, String inntektsaar, String personidentifikator) throws IOException {
        Call<BeregnetSkattDto> request = getApi().getBeregnetSkatt(rettighetspakke, inntektsaar, personidentifikator);
        return executeRequest(request, response -> new BeregnetSkattMapper().mapToBeregnetSkatt(response), new BeregnetSkattExceptionMapper());
    }
}
