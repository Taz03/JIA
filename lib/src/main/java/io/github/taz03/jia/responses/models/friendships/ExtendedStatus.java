package io.github.taz03.jia.responses.models.friendships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendedStatus extends Status {
    @JsonProperty("followed_by")
    private boolean followedBy;
    @JsonProperty("blocking")
    private boolean isBlocked;
    @JsonProperty("is_muting")
    private boolean isMuted;
    @JsonProperty("is_feed_favourite")
    private boolean isFeedFavourite;
    @JsonProperty("subscribed")
    private boolean isSubscribed;
    @JsonProperty("is_eligible_to_subscribe")
    private boolean isSubscribable;

    public boolean isFollowedBy() {
        return followedBy;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public boolean isFeedFavourite() {
        return isFeedFavourite;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public boolean isSubscribable() {
        return isSubscribable;
    }
}
