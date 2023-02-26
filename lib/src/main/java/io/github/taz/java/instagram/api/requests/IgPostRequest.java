package io.github.taz.java.instagram.api.requests;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class IgPostRequest<T extends IgResponse> extends IgRequest<T> {
    private String body;

	public IgPostRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, String> queries) {
		super(responseType, path, queries);
	}

	public IgPostRequest(Class<T> responseType, String path, Map<String, String> queries, Map<String, String> parameters) {
		super(responseType, path, queries);
        this.body = makeBody(parameters);
	}

    @Override
    public HttpRequest formRequest(IgClient client) {
        return HttpRequest.newBuilder()
            .uri(URI.create(this.getUrl()))
            .headers(IgRequest.getHeaders(client))
            .POST(BodyPublishers.ofString(body))
            .build();
    }

    private static String makeBody(Map<String, String> parameters) {
        return parameters.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));
    }
}
