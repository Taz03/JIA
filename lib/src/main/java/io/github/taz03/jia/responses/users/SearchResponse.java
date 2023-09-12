package io.github.taz03.jia.responses.users;

import java.util.List;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.user.SearchProfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @Override
    public String toString() {
        return "SearchResponse{" +
                "results=" + results +
                ", profiles=" + profiles +
                ", hasMore=" + hasMore +
                ", rankToken='" + rankToken + '\'' +
                '}';
    }
}
