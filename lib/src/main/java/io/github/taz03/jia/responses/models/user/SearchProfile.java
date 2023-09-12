package io.github.taz03.jia.responses.models.user;

import io.github.taz03.jia.responses.models.friendships.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchProfile {
    @JsonUnwrapped
    private Profile profile;
    @JsonProperty("friendship_status")
    private Status friendshipStatus;

    public Profile getProfile() {
        return profile;
    }

    public Status getFriendshipStatus() {
        return friendshipStatus;
    }

    @Override
    public String toString() {
        return "SearchProfile{" +
                "profile=" + profile +
                ", friendshipStatus=" + friendshipStatus +
                '}';
    }
}
