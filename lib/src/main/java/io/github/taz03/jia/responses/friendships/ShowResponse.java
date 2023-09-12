package io.github.taz03.jia.responses.friendships;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.friendships.ExtendedStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShowResponse extends InstagramResponse {
    @JsonUnwrapped
    private ExtendedStatus extendedStatus;
    @JsonProperty("is_blocking_reel")
    private boolean isBlockingReel;
    @JsonProperty("is_muting_reel")
    private boolean isMutingReel;
    @JsonProperty("is_supervised_by_viewer")
    private boolean isSupervised;
    @JsonProperty("is_guardian_of_viewer")
    private boolean isGuardian;
    @JsonProperty("is_muting_notes")
    private boolean isMutingNotes;

    public ExtendedStatus getExtendedStatus() {
        return extendedStatus;
    }

    public boolean isBlockingReel() {
        return isBlockingReel;
    }

    public boolean isMutingReel() {
        return isMutingReel;
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
