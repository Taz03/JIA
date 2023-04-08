package io.github.taz03.jia.responses.models.friendship;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Status {
    @JsonProperty("following")
    private boolean following;
    @JsonProperty("incoming_request")
    private boolean incomingRequest;
    @JsonProperty("is_bestie")
    private boolean isBestie;
    @JsonProperty("is_private")
    private boolean isPrivate;
    @JsonProperty("is_restricted")
    private boolean isRestricted;
    @JsonProperty("outgoing_request")
    private boolean outgoingRequest;

    public boolean isFollowing() {
        return following;
    }

    public boolean hasIncomingRequest() {
        return incomingRequest;
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
        return outgoingRequest;
    }
}
