package io.github.taz.java.instagram.api.requests;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;

public class IgGetRequest<T extends IgResponse> extends IgRequest<T> {
	public IgGetRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	public IgGetRequest(Class<T> responseType, String path, Map<String, String> queries) {
		super(responseType, path, queries);
	}

	@Override
	public HttpRequest formRequest(IgClient client) {
        return HttpRequest.newBuilder(URI.create(this.getUrl()))
            .headers(IgRequest.getHeaders(client))
            .GET()
            .build();
	}
}
