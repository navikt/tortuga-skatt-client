package no.nav.opptjening.skatt.client.api;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpRequestLogger implements Interceptor {
    private static final Logger LOG = LoggerFactory.getLogger(HttpRequestLogger.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LOG.debug("{} {}\n{}", request.method(), request.url(), request.headers());
        return chain.proceed(request);
    }
}
