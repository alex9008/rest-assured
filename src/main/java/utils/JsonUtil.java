package utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.apache.commons.lang3.StringUtils;

public abstract class JsonUtil {

    public static final String DEFAULT_CHARSET = "UTF-8";

    private static final ObjectMapper objectMapper;
    private static final ObjectMapper camelObjectMapper;
    private static final ObjectMapper upperCamelObjectMapper;
    private static final ObjectMapper newObjectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new AfterburnerModule());
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        objectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        newObjectMapper = new ObjectMapper();
        newObjectMapper.registerModule(new AfterburnerModule());
        newObjectMapper.registerModule(new JavaTimeModule());
        newObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        newObjectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        newObjectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        newObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        newObjectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));

        camelObjectMapper = new ObjectMapper();
        camelObjectMapper.registerModule(new AfterburnerModule());
        camelObjectMapper.registerModule(new JavaTimeModule());
        camelObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        camelObjectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        camelObjectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        camelObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);

        upperCamelObjectMapper = new ObjectMapper();
        upperCamelObjectMapper.registerModule(new AfterburnerModule());
        upperCamelObjectMapper.registerModule(new JavaTimeModule());
        upperCamelObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        upperCamelObjectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        upperCamelObjectMapper.enable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
        upperCamelObjectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
    }

    /**
     * getObjectMapper is deprecated, please use getNewObjectMapper which is the same plus has a correct way of formatting dates
     * @return
     */
    @Deprecated
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static ObjectMapper getCamelObjectMapper() {
        return camelObjectMapper;
    }

    public static ObjectMapper getUpperCamelObjectMapper() {
        return upperCamelObjectMapper;
    }

    public static ObjectMapper getNewObjectMapper() {
        return newObjectMapper;
    }

    public static <T> String serialize(T source) {
        if (source == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String serializeCamel(T source) {
        if (source == null) {
            return null;
        }
        try {
            return camelObjectMapper.writeValueAsString(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> String serializeNew(T source) {
        if (source == null) {
            return null;
        }
        try {
            return newObjectMapper.writeValueAsString(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserializeUpperCamel(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return upperCamelObjectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserializeCamel(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return camelObjectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserializeNew(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return newObjectMapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(String json, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
