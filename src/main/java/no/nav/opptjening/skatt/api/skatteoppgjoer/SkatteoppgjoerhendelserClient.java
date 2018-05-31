package no.nav.opptjening.skatt.api.skatteoppgjoer;

import no.nav.opptjening.skatt.api.hendelseliste.HendelserClient;

public class SkatteoppgjoerhendelserClient extends HendelserClient {

    public SkatteoppgjoerhendelserClient(String endepunkt, String apiKey) {
        super(endepunkt, apiKey);
    }
}
