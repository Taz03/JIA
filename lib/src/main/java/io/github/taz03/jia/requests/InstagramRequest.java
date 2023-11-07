package io.github.taz03.jia.requests;

import java.net.http.HttpRequest;
import java.util.Map;
import java.util.stream.Stream;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.utils.UrlUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Represents a generic Instagram request.
 */
public abstract class InstagramRequest<T extends InstagramResponse> {
    private static final ObjectMapper mapper = new ObjectMapper();

    private final Class<T> responseType;
    private String url = "https://i.instagram.com";

    /**
     * Constructs a generic Instagram request with the specified response type and path.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     */
    protected InstagramRequest(Class<T> responseType, String path) {
        this(responseType, path, null);
    }
    
    /**
     * Constructs a generic Instagram request with the specified response type, path and query parameters.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     * @param queries      The queries to send
     */
    protected InstagramRequest(Class<T> responseType, String path, Map<String, Object> queries) {
        this.responseType = responseType;
        this.url += path;

        if (queries != null && !queries.isEmpty())
            url += "?" + UrlUtils.makeBody(queries);
    }

    /**
     * @return The full url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return The response class type of this request
     */
    public Class<T> getResponseType() {
        return responseType;
    }

    /**
     * Makes a {@link HttpRequest} to send using {@link java.net.http.HttpClient}.
     *
     * @param client The client to generate this request for
     */
    public abstract HttpRequest formRequest(InstagramClient client);

    /**
     * Parses json string to the corresponding response class.
     *
     * @param json The string json
     * @return     Parsed response class
     */
    public T parseResponse(String json) throws JsonProcessingException {
        T response = mapper.readValue(json, responseType);
        response.setJson(json);

        return response;
    }

    protected Map<String, Object> getHeaders(InstagramClient client) {
        return Map.of(
            "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8",
            "User-Agent", "Instagram 265.0.0.19.301 Android (33/13; 374dpi; 1080x2224; Google/google; sdk_gphone64_x86_64; emu64x; ranchu; en_US; 436384448)",
            "Authorization", client.getAuthorization() == null ? "" : client.getAuthorization()
        );
    }

    protected static String[] makeHeaderArray(Map<String, Object> headers) {
        return headers.keySet().stream()
            .flatMap(key -> Stream.of(key, headers.get(key).toString()))
            .toList()
            .toArray(new String[0]);
    }
}
