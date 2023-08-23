package io.github.taz03.jia.responses.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.User;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendshipsFeedResponse extends InstagramResponse {
    @JsonProperty("users")
    private List<User> users;

    public List getUsers() {
        return users;
    }
}
