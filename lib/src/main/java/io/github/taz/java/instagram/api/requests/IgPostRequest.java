package io.github.taz.java.instagram.api.requests;

import io.github.taz.java.instagram.api.response.*;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

public abstract class IgPostRequest<T extends IgResponse> extends IgRequest<T> {
	public IgPostRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, String> queries) {
		super(responseType, path, queries);
	}

    @Override
    public HttpRequest formRequest() {
        // TODO add headers and make it a post request
        return HttpRequest.newBuilder()
            .uri(URI.create(this.getUrl()))
            .build();
    }
}
