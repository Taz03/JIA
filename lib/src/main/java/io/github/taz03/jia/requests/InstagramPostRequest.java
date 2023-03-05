package io.github.taz03.jia.requests;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.utils.UrlUtils;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;

public abstract class InstagramPostRequest<T extends InstagramResponse> extends InstagramRequest<T> {
    private String body = "";

	protected InstagramPostRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	protected InstagramPostRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		super(responseType, path, queries);
	}

	protected InstagramPostRequest(Class<T> responseType, String path, Map<String, Object> queries, Map<String, Object> payload) {
		super(responseType, path, queries);
        this.body = UrlUtils.makeBody(payload);
	}

    @Override
    public HttpRequest formRequest(InstagramClient client) {
        return HttpRequest.newBuilder(URI.create(this.getUrl()))
            .headers(InstagramRequest.getHeaders(client))
            .POST(BodyPublishers.ofString(body))
            .build();
    }
}
