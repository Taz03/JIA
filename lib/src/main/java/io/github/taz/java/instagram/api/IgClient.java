package io.github.taz.java.instagram.api;

import io.github.taz.java.instagram.api.requests.IgRequest;
import io.github.taz.java.instagram.api.response.IgResponse;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.util.concurrent.CompletableFuture;

public final class IgClient {
    private final String username, password;
    private String encryptionId, encryptionKey, authorization;
    private HttpClient httpClient;

    public IgClient(String username, String password) {
        this.username = username;
        this.password = password;
        // login after this
    }

    public <T extends IgResponse> CompletableFuture<HttpResponse<T>> sendRequest(IgRequest<T> request, BodyHandler<T> handler) {
        return httpClient.sendAsync(request.formRequest(), handler);
    }
}
