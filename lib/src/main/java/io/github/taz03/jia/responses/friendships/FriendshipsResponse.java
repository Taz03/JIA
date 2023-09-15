package io.github.taz03.jia.responses.friendships;

import java.util.List;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class FriendshipsResponse extends InstagramResponse {
    @JsonProperty("users")
    private List<User> users;
    @JsonProperty("big_list")
    private boolean hasMore;
    @JsonProperty("next_max_id")
    private String nextMaxId;

    public List<User> getUsers() {
        return users;
    }

    public boolean hasMore() {
        return hasMore;
    }

    public String getNextMaxId() {
        return nextMaxId;
    }

    @Override
    public String toString() {
        return "FriendshipsResponse{" +
                "users=" + users +
                ", hasMore=" + hasMore +
                ", nextMaxId='" + nextMaxId + '\'' +
                '}';
    }
}
