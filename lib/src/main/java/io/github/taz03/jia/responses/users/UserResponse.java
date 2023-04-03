package io.github.taz03.jia.responses.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.User;

public final class UserResponse extends InstagramResponse {
    @JsonProperty("user")
    private User user;

    public User getUser() {
        return user;
    }
}
