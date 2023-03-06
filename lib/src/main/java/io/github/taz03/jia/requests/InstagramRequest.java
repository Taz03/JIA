package io.github.taz03.jia.requests;

import java.net.http.HttpRequest;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.utils.UrlUtils;

public abstract class InstagramRequest<T extends InstagramResponse> {
    private static final ObjectMapper mapper = new ObjectMapper();

    private final Class<T> responseType;
    private String url = "https://i.instagram.com/api/v1";

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

        if (queries != null && queries.size() > 0)
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
     * @param client The client to use to make the request
     */
    public abstract HttpRequest formRequest(InstagramClient client);

    /**
     * Parses json string to the corresponding response class.
     *
     * @param json The string json
     * @return     Parsed response class
     */
    public T parseResponse(String json) throws JsonProcessingException {
        return mapper.readValue(json, responseType);
    }

    protected static String[] getHeaders(InstagramClient client) {
        return new String[] {
            "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8",
            "User-Agent", "Instagram 265.0.0.19.301 Android (33/13; 374dpi; 1080x2224; Google/google; sdk_gphone64_x86_64; emu64x; ranchu; en_US; 436384448)",
            "Authorization", client.getAuthorization() == null ? "" : client.getAuthorization(),
        };
    }
}
