package io.github.taz03.jia.requests;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.utils.UrlUtils;

/**
 * Represents an Instagram POST request.
 */
public abstract class InstagramPostRequest<T extends InstagramResponse> extends InstagramRequest<T> {
    private final BodyPublisher bodyPublisher;

    /**
     * Constructs an Instagram POST request with specified response type and path.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     */
	protected InstagramPostRequest(Class<T> responseType, String path) {
		this(responseType, path, null);
	}

    /**
     * Constructs an Instagram POST request with specified response type, path and query parameters.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     * @param queries      The queries to send
     */
	protected InstagramPostRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		this(responseType, path, queries, Map.of());
	}

	/**
     * Constructs an Instagram POST request with specified response type, path, query parameters and payload data.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     * @param queries      The queries to send
	 * @param payload      The payload data to send
	 */
	protected InstagramPostRequest(Class<T> responseType, String path, Map<String, Object> queries, Map<String, Object> payload) {
		super(responseType, path, queries);
        this.bodyPublisher = BodyPublishers.ofString(UrlUtils.makeBody(payload));
	}

	/**
     * Constructs an Instagram POST request with specified response type, path, query parameters and body.
     *
     * @param responseType  Response type to parse the response json into
     * @param path          The path of the API endpoint that the client wants to access
     * @param queries       The queries to send
	 * @param bodyPublisher Custom body to send
	 */
	protected InstagramPostRequest(Class<T> responseType, String path, Map<String, Object> queries, BodyPublisher bodyPublisher) {
        super(responseType, path, queries);
        this.bodyPublisher = bodyPublisher;
    }

    @Override
    public HttpRequest formRequest(InstagramClient client) {
        return HttpRequest.newBuilder(URI.create(getUrl()))
            .headers(makeHeaderArray(getHeaders(client)))
            .POST(bodyPublisher)
            .build();
    }
}
