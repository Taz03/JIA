package io.github.taz03.jia.responses.users;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.SearchProfile;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SearchResponse extends InstagramResponse {
    @JsonProperty("num_results")
    private int results;
    @JsonProperty("users")
    private List<SearchProfile> profiles;
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonProperty("rank_token")
    private String rankToken;

    public int getResults() {
        return results;
    }

    public List<SearchProfile> getProfiles() {
        return profiles;
    }

    public boolean hasMore() {
        return hasMore;
    }

    public String getRankToken() {
        return rankToken;
    }
}
