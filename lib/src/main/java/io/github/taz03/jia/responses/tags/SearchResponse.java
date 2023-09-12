package io.github.taz03.jia.responses.tags;

import java.util.List;

import io.github.taz03.jia.responses.InstagramResponse;
import io.github.taz03.jia.responses.models.tag.SearchTag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse extends InstagramResponse {
    @JsonProperty("has_more")
    private boolean hasMore;
    @JsonProperty("rank_token")
    private String rankToken;
    @JsonProperty("results")
    private List<SearchTag> results;

    public boolean hasMore() {
        return hasMore;
    }

    public String getRankToken() {
        return rankToken;
    }

    public List<SearchTag> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "hasMore=" + hasMore +
                ", rankToken='" + rankToken + '\'' +
                ", results=" + results +
                '}';
    }
}
