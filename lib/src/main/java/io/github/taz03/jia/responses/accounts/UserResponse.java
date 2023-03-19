package io.github.taz03.jia.responses.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.taz03.jia.models.user.User;
import io.github.taz03.jia.responses.InstagramResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserResponse extends InstagramResponse {
    @JsonProperty("user")
    private User user;

    public User getUser() {
        return user;
    }
}
