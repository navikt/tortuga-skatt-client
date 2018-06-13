package no.nav.opptjening.skatt.client.api;

import okhttp3.Interceptor;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpResponseLogger implements Interceptor {
    private static final Logger LOG = LoggerFactory.getLogger(HttpResponseLogger.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        long t1 = System.nanoTime();
        Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
        LOG.debug("Received {} for {} in {} ms\n{}", response.code(), response.request().url(), (t2 - t1) / 1e6d, response.headers());
        return response;
    }
}
