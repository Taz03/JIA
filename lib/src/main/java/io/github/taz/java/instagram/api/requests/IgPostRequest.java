package io.github.taz.java.instagram.api.requests;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;
import io.github.taz.java.instagram.api.utils.UrlUtils;

import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;

public abstract class IgPostRequest<T extends IgResponse> extends IgRequest<T> {
    private String body = "";

	public IgPostRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, String> queries) {
		super(responseType, path, queries);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, String> queries, Map<String, String> parameters) {
		super(responseType, path, queries);
        this.body = UrlUtils.makeBody(parameters);
	}

    @Override
    public HttpRequest formRequest(IgClient client) {
        return HttpRequest.newBuilder(this.getUri())
            .headers(IgRequest.getHeaders(client))
            .POST(BodyPublishers.ofString(body))
            .build();
    }
}
