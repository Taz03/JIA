package io.github.taz03.jia.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public final class UrlUtils {
    private UrlUtils() {
        throw new UnsupportedOperationException("Utility class, construction not supported");
    }

    public static String makeBody(Map<String, Object> parameters) {
        return parameters.entrySet()
            .stream()
            .map(entry -> entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8))
            .collect(Collectors.joining("&"));
    }
}
