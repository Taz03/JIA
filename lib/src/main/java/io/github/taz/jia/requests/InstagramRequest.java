package io.github.taz.jia.requests;

import java.net.http.HttpRequest;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.taz.jia.InstagramClient;
import io.github.taz.jia.responses.InstagramResponse;
import io.github.taz.jia.utils.UrlUtils;

public abstract class InstagramRequest<T extends InstagramResponse> {
    private static final ObjectMapper mapper = new ObjectMapper();

    private final Class<T> responseType;
    private String url = "https://i.instagram.com/api/v1";

    public InstagramRequest(Class<T> responseType, String path) {
        this(responseType, path, null);
    }
    
    public InstagramRequest(Class<T> responseType, String path, Map<String, Object> queries) {
        this.responseType = responseType;
        this.url += path;

        if (queries != null && queries.size() > 0)
            url += "?" + UrlUtils.makeBody(queries);
    }

    public String getUrl() {
        return url;
    }

    public Class<T> getResponseType() {
        return responseType;
    }

    public abstract HttpRequest formRequest(InstagramClient client);

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
