package io.github.taz03.jia.requests.fbsearch;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.fbsearch.AccountSerpResponse;

/**
 * Represents an Instagram account serp request, used to search for users.
 * <br><br>
 * To get scroll through the results, use the page_token got in response of previous page.
 * <br>
 * Example:
 * {@snippet :
 * String query = "query";
 * AccountSerpRequest firstSearch = new AccountSerpRequest(query);
 * AccountSerpResponse firstPage = client.sendRequest(firstSearch).get();
 *
 * if (firstPage.hasMore()) {
 *     AccountSerpRequest secondSearch = new AccountSerpRequest(query, firstPage.getPageToken());
 *     AccountSerpResponse secondPage = client.sendRequest(secondSearch).get();
 * }
 * }
 */
public final class AccountSerpRequest extends InstagramGetRequest<AccountSerpResponse> {
    /**
     * Creates an Instagram account serp request.
     *
     * @param query the serach query
     */
    public AccountSerpRequest(String query) {
        this(query, null);
    }

	/**
     * Creates an Instagram account serp request.
     *
	 * @param query     the search query
	 * @param pageToken the page_token recieved in previous response
	 */
	public AccountSerpRequest(String query, String pageToken) {
		super(AccountSerpResponse.class, "/api/v1/fbsearch/account_serp/", Map.of(
            "query", query,
            "page_token", pageToken
        ));
	}
}
