package io.github.taz03.jia.requests;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.utils.UrlUtils;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;

/**
 * Represents an Instagram POST request.
 */
public abstract class InstagramPostRequest<T extends InstagramResponse> extends InstagramRequest<T> {
    private String body = "";

    /**
     * Constructs an Insatagram POST request wtih specified response type and path.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     */
	protected InstagramPostRequest(Class<T> responseType, String path) {
		super(responseType, path);
	}

    /**
     * Constructs an Insatagram POST request wtih specified response type, path and query parameters.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     * @param queries      The queries to send
     */
	protected InstagramPostRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		super(responseType, path, queries);
	}

	/**
     * Constructs an Insatagram POST request wtih specified response type, path, query parameters and payload data.
     *
     * @param responseType Response type to parse the response json into
     * @param path         The path of the API endpoint that the client wants to access
     * @param queries      The queries to send
	 * @param payload      The payload data to send
	 */
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
