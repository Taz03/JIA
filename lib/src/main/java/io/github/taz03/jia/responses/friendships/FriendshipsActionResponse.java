package io.github.taz03.jia.responses.friendships;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.friendship.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendshipsActionResponse extends InstagramResponse {
   @JsonProperty("friendship_status")
    private Status friendshipStatus;

    public Status getFriendshipStatus() {
        return friendshipStatus;
    }
}
