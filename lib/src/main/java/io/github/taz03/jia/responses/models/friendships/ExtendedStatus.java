package io.github.taz03.jia.responses.models.friendships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ExtendedStatus {
    @JsonUnwrapped
    private Status status;
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

    public Status getStatus() {
        return status;
    }

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

    @Override
    public String toString() {
        return "ExtendedStatus{" +
                ", status=" + status +
                ", followedBy=" + followedBy +
                ", isBlocked=" + isBlocked +
                ", isMuted=" + isMuted +
                ", isFeedFavourite=" + isFeedFavourite +
                ", isSubscribed=" + isSubscribed +
                ", isSubscribable=" + isSubscribable +
                '}';
    }
}
