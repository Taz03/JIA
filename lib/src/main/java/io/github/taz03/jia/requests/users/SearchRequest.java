package io.github.taz03.jia.requests.users;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.users.SearchResponse;

/**
 * Represents an Instagram users search request, used to search for users.
 * <br><br>
 * To get scroll through the results, use the rank_token got in response of previous page.
 * <br>
 * Example:
 * {@snippet :
 * String query = "query";
 * SearchRequest firstSearch = new AccountSerpRequest(query);
 * SearchResponse firstPage = client.sendRequest(firstSearch).get();
 *
 * if (firstPage.hasMore()) {
 *     SearchRequest secondSearch = new AccountSerpRequest(query, firstPage.getRankToken());
 *     SearchResponse secondPage = client.sendRequest(secondSearch).get();
 * }
 * }
 */
public final class SearchRequest extends InstagramGetRequest<SearchResponse> {
    /**
     * Creates an Instagram users search request.
     *
     * @param query the serach query
     */
    public SearchRequest(String query) {
        this(query, "");
    }

	/**
     * Creates an Instagram users search request.
     *
	 * @param query     the search query
	 * @param rankToken the rank_token recieved in previous response page
	 */
	public SearchRequest(String query, String rankToken) {
		super(SearchResponse.class, "/api/v1/users/search/", Map.of(
            "q", query,
            "rank_token", rankToken
        ));
	}
}
