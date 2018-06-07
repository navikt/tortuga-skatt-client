package no.nav.opptjening.skatt.client.api;

import com.fasterxml.jackson.databind.ObjectReader;
import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

public class JacksonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final ObjectReader adapter;

    JacksonResponseBodyConverter(ObjectReader adapter) {
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException {
        String jsonString = value.string();
        try {
            return adapter.readValue(jsonString);
        } catch (Exception e) {
            throw new ResponseBodyConverterException("Failed to convert the JSON: " + jsonString, e);
        } finally {
            value.close();
        }
    }
}
