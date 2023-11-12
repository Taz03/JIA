package io.github.taz03.jia.responses.friendships;

import java.util.Map;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.friendships.Status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ShowManyResponse extends InstagramResponse {
    @JsonProperty("friendship_statuses")
    Map<String, Status> statuses;

    public Map<String, Status> getStatuses() {
        return statuses;
    }

    @Override
    public String toString() {
        return "ShowManyResponse{" + "statuses=" + statuses + '}';
    }
}
