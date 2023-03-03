package io.github.taz.java.instagram.api.requests;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;
import io.github.taz.java.instagram.api.utils.UrlUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Map;

public abstract class IgPostRequest<T extends IgResponse> extends IgRequest<T> {
    private String body = "";
	public static final Logger logger = LoggerFactory.getLogger(IgPostRequest.class);
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
		logger.info("Sending POST request to {}", this.getUrl());
        return HttpRequest.newBuilder(URI.create(this.getUrl()))
            .headers(IgRequest.getHeaders(client))
            .POST(BodyPublishers.ofString(body))
            .build();
    }
}
