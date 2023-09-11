package io.github.taz03.jia.responses.friendships;

import io.github.taz03.jia.responses.InstagramResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowResponse extends InstagramResponse {
    @JsonProperty("blocking")
    private boolean isBlocked;
    @JsonProperty("followed_by")
    private boolean followedBy;
    @JsonProperty("following")
    private boolean following;
    @JsonProperty("incoming_request")
    private boolean hasIncomingRequest;
    @JsonProperty("is_bestie")
    private boolean isBestie;
    @JsonProperty("is_blocking_reel")
    private boolean isBlockingReel;
    @JsonProperty("is_muting_reel")
    private boolean isMutingReel;
    @JsonProperty("is_private")
    private boolean isPrivate;
    @JsonProperty("is_restricted")
    private boolean isRestricted;
    @JsonProperty("muting")
    private boolean isMuted;
    @JsonProperty("outgoing_request")
    private boolean hasOutgoingRequest;
    @JsonProperty("is_feed_favourite")
    private boolean isFeedFavourite;
    @JsonProperty("subscribed")
    private boolean isSubscribed;
    @JsonProperty("is_eligible_to_subscribe")
    private boolean isSubscribable;
    @JsonProperty("is_supervised_by_viewer")
    private boolean isSupervised;
    @JsonProperty("is_guardian_of_viewer")
    private boolean isGuardian;
    @JsonProperty("is_muting_notes")
    private boolean isMutingNotes;

    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean isFollowedBy() {
        return followedBy;
    }

    public boolean isFollowing() {
        return following;
    }

    public boolean hasIncomingRequest() {
        return hasIncomingRequest;
    }

    public boolean isBestie() {
        return isBestie;
    }

    public boolean isBlockingReel() {
        return isBlockingReel;
    }

    public boolean isMutingReel() {
        return isMutingReel;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public boolean hasOutgoingRequest() {
        return hasOutgoingRequest;
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

    public boolean isSupervised() {
        return isSupervised;
    }

    public boolean isGuardian() {
        return isGuardian;
    }

    public boolean isMutingNotes() {
        return isMutingNotes;
    }
}
