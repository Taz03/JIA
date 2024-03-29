package io.github.taz03.jia.responses.accounts;

import io.github.taz03.jia.responses.models.user.User;
import io.github.taz03.jia.responses.InstagramResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class LoginResponse extends InstagramResponse {
    @JsonProperty("logged_in_user")
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "user=" + user +
                '}';
    }
}
