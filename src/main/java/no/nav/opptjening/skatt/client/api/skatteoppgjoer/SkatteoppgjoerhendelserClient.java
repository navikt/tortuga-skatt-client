package no.nav.opptjening.skatt.client.api.skatteoppgjoer;

import no.nav.opptjening.skatt.client.api.hendelseliste.HendelserClient;

public class SkatteoppgjoerhendelserClient extends HendelserClient {

    public SkatteoppgjoerhendelserClient(String endepunkt, String apiKey) {
        super(endepunkt, apiKey);
    }
}
