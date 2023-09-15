package io.github.taz03.jia.responses.friendships;

import io.github.taz03.jia.responses.InstagramResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.taz03.jia.responses.models.friendships.ExtendedStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendshipsActionResponse extends InstagramResponse {
   @JsonProperty("friendship_status")
    private ExtendedStatus friendshipStatus;

    public ExtendedStatus getFriendshipStatus() {
        return friendshipStatus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
