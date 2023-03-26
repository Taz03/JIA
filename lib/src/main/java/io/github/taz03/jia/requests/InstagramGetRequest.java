package io.github.taz03.jia.requests;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.responses.InstagramResponse;

/**
 * Represents an Instagram GET request.
 */
public abstract class InstagramGetRequest<T extends InstagramResponse> extends InstagramRequest<T> {
    /**
     * Constructs an Instagram GET request with the specified response type and path.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     */
	protected InstagramGetRequest(Class<T> responseType, String path) {
		super(responseType, path);
	}

    /**
     * Constructs an Instagram GET request with the specified response type, path, and query parameters.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     * @param queries      The queries to send
     */
	protected InstagramGetRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		super(responseType, path, queries);
	}

	@Override
	public HttpRequest formRequest(InstagramClient client) {
        return HttpRequest.newBuilder(URI.create(super.getUrl()))
            .headers(super.makeHeaderArray(super.getHeaders(client)))
            .GET()
            .build();
	}
}
