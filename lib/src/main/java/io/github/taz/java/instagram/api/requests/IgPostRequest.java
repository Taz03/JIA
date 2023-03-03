package io.github.taz.java.instagram.api.requests;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;
import io.github.taz.java.instagram.api.utils.UrlUtils;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;

public abstract class IgPostRequest<T extends IgResponse> extends IgRequest<T> {
    private String body = "";

	public IgPostRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		super(responseType, path, queries);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, Object> queries, Map<String, Object> payload) {
		super(responseType, path, queries);
        this.body = UrlUtils.makeBody(payload);
	}

    @Override
    public HttpRequest formRequest(IgClient client) {
        return HttpRequest.newBuilder(URI.create(this.getUrl()))
            .headers(IgRequest.getHeaders(client))
            .POST(BodyPublishers.ofString(body))
            .build();
    }
}
