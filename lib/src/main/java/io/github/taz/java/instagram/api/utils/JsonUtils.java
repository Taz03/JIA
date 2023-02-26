package io.github.taz.java.instagram.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T jsonToObject(String json, Class<T> clazz) throws JsonProcessingException {
        return MAPPER.readValue(json, clazz);
    }

    public static String objectToJson(Object object) throws JsonProcessingException {
        return MAPPER.writer().writeValueAsString(object);
    }
}
