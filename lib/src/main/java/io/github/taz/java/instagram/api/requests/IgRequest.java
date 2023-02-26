package io.github.taz.java.instagram.api.requests;

import java.net.http.HttpRequest;
import java.util.Map;

import io.github.taz.java.instagram.api.response.IgResponse;

public abstract class IgRequest<T extends IgResponse> {
    private final Class<T> responseType;
    private String url = "https://i.instagram.com/api/v1/";

    public IgRequest(Class<T> responseType, String path) {
        this(responseType, path, null);
    }
    
    public IgRequest(Class<T> responseType, String path, Map<String, String> queries) {
        this.responseType = responseType;
        this.url += path;

        if (queries == null || queries.size() <= 0) return;
        url += "?";
        queries.forEach((key, value) -> url += key + "=" + value + "&");
    }

    public abstract HttpRequest formRequest();

    public abstract Class<T> getResponseType();
}
