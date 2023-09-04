package io.github.taz03.jia.responses.friendships;

import java.util.List;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendshipsFeedResponse extends InstagramResponse {
    @JsonProperty("users")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
