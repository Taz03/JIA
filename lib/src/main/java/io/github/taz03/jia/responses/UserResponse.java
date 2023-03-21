package io.github.taz03.jia.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.taz03.jia.responses.models.user.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserResponse extends InstagramResponse {
    @JsonProperty("user")
    private User user;

    public User getUser() {
        return user;
    }
}
