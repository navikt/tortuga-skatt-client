package no.nav.opptjening.skatt.api;

import okhttp3.ResponseBody;
import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecord;
import org.apache.avro.specific.SpecificRecordBase;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class AvroConverterFactory extends Converter.Factory {

    private final Map<Class<?>, Converter<ResponseBody, ?>> converters;

    public AvroConverterFactory() {
        this(null);
    }

    public AvroConverterFactory(Map<Class<?>, Converter<ResponseBody, ?>> converters) {
        super();
        this.converters = converters;
    }

    private Converter<ResponseBody, ? extends SpecificRecord> defaultConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Schema schema = getSchema(getRawType(type));

        if (schema == null) {
            throw new IllegalArgumentException("Unable to get schema for " + type.getTypeName());
        }

        return new AvroResponseBodyConverter<>(schema, type, annotations, retrofit);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (converters != null) {
            for (Map.Entry<Class<?>, Converter<ResponseBody, ?>> entry : converters.entrySet()) {
                if (entry.getKey().getTypeName().equals(type.getTypeName())) {
                    return entry.getValue();
                }
            }
        }
        return defaultConverter(type, annotations, retrofit);
    }

    public static Converter.Factory create() {
        return new AvroConverterFactory();
    }

    private Schema getSchema(Class<?> cls) {
        if (!SpecificRecordBase.class.isAssignableFrom(cls)) {
            return null;
        }

        Method method = null;
        Field field = null;

        try {
            method = cls.getMethod("getClassSchema");
        } catch (NoSuchMethodException e) {
            /* continue */
        }

        if (method == null) {
            try {
                field = cls.getDeclaredField("SCHEMA$");
            } catch (NoSuchFieldException e) {
                return null;
            }
        }

        Object schema;
        try {
            if (method == null) {
                schema = field.get(null);
            } else {
                schema = method.invoke(null);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            return null;
        }

        if (schema instanceof Schema) {
            return (Schema) schema;
        }

        return null;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Map<Class<?>, Converter<ResponseBody, ?>> converters = new HashMap<>();

        public Builder addConverter(Class<?> clazz, Converter<ResponseBody, ?> converter) {
            converters.put(clazz, converter);
            return this;
        }

        public AvroConverterFactory build() {
            return new AvroConverterFactory(converters);
        }
    }
}
