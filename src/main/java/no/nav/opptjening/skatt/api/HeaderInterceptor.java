package no.nav.opptjening.skatt.api;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class HeaderInterceptor implements Interceptor {

    private final String header;
    private final String value;

    public HeaderInterceptor(String header, String value) {
        this.header = header;
        this.value = value;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (originalRequest.header(header) != null) {
            return chain.proceed(originalRequest);
        }

        Request newRequest = originalRequest.newBuilder()
                .header(header, value)
                .build();

        return chain.proceed(newRequest);
    }
}
