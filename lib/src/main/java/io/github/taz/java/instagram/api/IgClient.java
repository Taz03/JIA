package io.github.taz.java.instagram.api;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.github.taz.java.instagram.api.requests.IgRequest;
import io.github.taz.java.instagram.api.requests.accounts.AccountsLoginRequest;
import io.github.taz.java.instagram.api.responses.IgResponse;

import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;

public final class IgClient {
    private final String username, password;
    private String encryptionId, encryptionKey, authorization, cookies;
    private HttpClient httpClient;

    public IgClient(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEncryptionId() {
        return encryptionId;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getCookies() {
        return cookies;
    }

    public void login() throws Exception {
        sendRequest(new AccountsLoginRequest(username, password)).join();
    }

    public <T extends IgResponse> CompletableFuture<T> sendRequest(IgRequest<T> request) {
        return httpClient.sendAsync(request.formRequest(this), BodyHandlers.ofString())
                .thenApply(response -> {
                    setFromResponseHeaders(response.headers());
                    try {
                        return request.parseResponse(response.body());
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void setFromResponseHeaders(HttpHeaders headers) {
        headers.firstValue("ig-set-password-encryption-key-id")
                .ifPresent(value -> this.encryptionId = value);
        headers.firstValue("ig-set-password-encryption-pub-key")
                .ifPresent(value -> this.encryptionKey = value);
        headers.firstValue("ig-set-authorization")
                .ifPresent(value -> this.authorization = value);
        this.cookies = "";
        headers.allValues("set-cookie")
                .forEach(cookie -> this.cookies += cookie);
    }
}
