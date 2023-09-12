package io.github.taz03.jia.responses.users;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class UserResponse extends InstagramResponse {
    @JsonProperty("user")
    private User user;

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "user=" + user +
                '}';
    }
}
