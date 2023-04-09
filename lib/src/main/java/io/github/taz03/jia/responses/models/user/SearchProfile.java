package io.github.taz03.jia.responses.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.github.taz03.jia.responses.models.friendship.Status;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SearchProfile {
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
}
