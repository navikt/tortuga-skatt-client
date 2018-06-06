package no.nav.opptjening.skatt.api.beregnetskatt;

import no.nav.opptjening.skatt.BeregnetSkatt;
import no.nav.opptjening.skatt.BeregnetSkattMapper;
import no.nav.opptjening.skatt.api.AbstractClient;
import no.nav.opptjening.skatt.schema.BeregnetSkattDto;
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
