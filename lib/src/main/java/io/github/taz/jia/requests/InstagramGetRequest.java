package io.github.taz.jia.requests;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

import io.github.taz.jia.InstagramClient;
import io.github.taz.jia.responses.InstagramResponse;

public class InstagramGetRequest<T extends InstagramResponse> extends InstagramRequest<T> {
	protected InstagramGetRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	protected InstagramGetRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		super(responseType, path, queries);
	}

	@Override
	public HttpRequest formRequest(InstagramClient client) {
        return HttpRequest.newBuilder(URI.create(this.getUrl()))
            .headers(InstagramRequest.getHeaders(client))
            .GET()
            .build();
	}
}
