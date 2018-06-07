package no.nav.opptjening.skatt.client.api;

import java.io.IOException;

public class ResponseBodyConverterException extends IOException {
    public ResponseBodyConverterException(String msg) {
        super(msg);
    }

    public ResponseBodyConverterException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
