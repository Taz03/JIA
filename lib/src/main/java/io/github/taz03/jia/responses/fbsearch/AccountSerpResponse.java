package io.github.taz03.jia.responses.fbsearch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.Profile;

public final class AccountSerpResponse extends InstagramResponse {
    @JsonProperty("num_results")
    private int results;
    @JsonProperty("users")
    private List<Profile> profiles;
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonProperty("page_token")
    private String pageToken;

    public int getResults() {
        return results;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public boolean hasMore() {
        return hasMore;
    }

    public String getPageToken() {
        return pageToken;
    }
}
