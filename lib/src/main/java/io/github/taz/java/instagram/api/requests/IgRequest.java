package io.github.taz.java.instagram.api.requests;

import java.net.http.HttpRequest;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;
import io.github.taz.java.instagram.api.utils.JsonUtils;
import io.github.taz.java.instagram.api.utils.UrlUtils;

public abstract class IgRequest<T extends IgResponse> {
    private final Class<T> responseType;
    private String url = "https://i.instagram.com/api/v1/";

    public IgRequest(Class<T> responseType, String path) {
        this(responseType, path, null);
    }
    
    public IgRequest(Class<T> responseType, String path, Map<String, Object> queries) {
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

    public abstract HttpRequest formRequest(IgClient client);

    public T parseResponse(String json) throws JsonProcessingException {
        return JsonUtils.jsonToObject(json, responseType);
    }

    protected static String[] getHeaders(IgClient client) {
        return new String[] {
            "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8",
            "User-Agent", "Instagram 265.0.0.19.301 Android (33/13; 374dpi; 1080x2224; Google/google; sdk_gphone64_x86_64; emu64x; ranchu; en_US; 436384448)",
            "Authorization", client.getAuthorization(),
            "Cookie", client.getCookies()
        };
    }
}
