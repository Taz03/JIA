package io.github.taz03.jia.responses.models.friendships;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Status {
    @JsonProperty("following")
    private boolean following;
    @JsonProperty("incoming_request")
    private boolean hasIncomingRequest;
    @JsonProperty("is_bestie")
    private boolean isBestie;
    @JsonProperty("is_private")
    private boolean isPrivate;
    @JsonProperty("is_restricted")
    private boolean isRestricted;
    @JsonProperty("outgoing_request")
    private boolean hasOutgoingRequest;

    public boolean isFollowing() {
        return following;
    }

    public boolean hasIncomingRequest() {
        return hasIncomingRequest;
    }

    public boolean isBestie() {
        return isBestie;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public boolean hasOutgoingRequest() {
        return hasOutgoingRequest;
    }

    @Override
    public String toString() {
        return "Status{" +
                "following=" + following +
                ", hasIncomingRequest=" + hasIncomingRequest +
                ", isBestie=" + isBestie +
                ", isPrivate=" + isPrivate +
                ", isRestricted=" + isRestricted +
                ", hasOutgoingRequest=" + hasOutgoingRequest +
                '}';
    }
}
