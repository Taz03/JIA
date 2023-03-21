package io.github.taz03.jia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Proxy Client
public final class TestProxy {
    public static InstagramClient client;
    public static User user;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final record User(
        @JsonProperty("username")
        String username,
        @JsonProperty("password")
        String password,
        @JsonProperty("phone_number")
        String phoneNumber,
        @JsonProperty("email")
        String email
    ) {}
}
