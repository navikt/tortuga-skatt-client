package no.nav.opptjening.skatt.client.api;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpRequestLogger implements Interceptor {
    private static final Logger LOG = LoggerFactory.getLogger(HttpRequestLogger.class);
    private final String[] ignoreHeaders;

    public HttpRequestLogger(@NotNull String... ignoreHeaders) {
        this.ignoreHeaders = ignoreHeaders;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = request.headers().size(); i < size; i++) {
            String header = request.headers().name(i);
            sb.append(header).append(": ");

            boolean ignore = false;
            for (String h : ignoreHeaders) {
                if (header.equalsIgnoreCase(h)) {
                    ignore = true;
                    break;
                }
            }

            if (!ignore) {
                sb.append(request.headers().value(i));
            } else {
                sb.append("********");
            }

            sb.append("\n");
        }

        LOG.debug("{} {}\n{}", request.method(), request.url(), sb.toString());
        return chain.proceed(request);
    }
}
