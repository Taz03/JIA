package io.github.taz.java.instagram.api;

import io.github.taz.java.instagram.api.requests.IgRequest;
import io.github.taz.java.instagram.api.response.IgResponse;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

public final class IgClient {
    private final String username, password;
    private HttpClient httpClient;
    private String encryptionId, encryptionKey, authorization;

    public IgClient(String username, String password) {
        this.username = username;
        this.password = password;
        // login after this
    }

    public <T extends IgResponse> CompletableFuture<T> sendRequest(IgRequest<T> request) {
    }
}
