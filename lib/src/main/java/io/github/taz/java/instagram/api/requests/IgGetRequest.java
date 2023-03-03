package io.github.taz.java.instagram.api.requests;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

import io.github.taz.java.instagram.api.IgClient;
import io.github.taz.java.instagram.api.responses.IgResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgGetRequest<T extends IgResponse> extends IgRequest<T> {
	public static final Logger logger = LoggerFactory.getLogger(IgGetRequest.class);
	public IgGetRequest(Class<T> responseType, String path) {
		super(responseType, path, null);
	}

	public IgGetRequest(Class<T> responseType, String path, Map<String, Object> queries) {
		super(responseType, path, queries);
	}

	@Override
	public HttpRequest formRequest(IgClient client) {
		logger.info("Making GET request for {}", this.getUrl());
        return HttpRequest.newBuilder(URI.create(this.getUrl()))
            .headers(IgRequest.getHeaders(client))
            .GET()
            .build();
	}
}
