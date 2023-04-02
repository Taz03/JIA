package io.github.taz03.jia.requests.fbsearch;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.fbsearch.AccountSerpResponse;

public final class AccountSerpRequest extends InstagramGetRequest<AccountSerpResponse> {
    public AccountSerpRequest(String query) {
        this(query, null);
    }

	public AccountSerpRequest(String query, String pageToken) {
		super(AccountSerpResponse.class, "/api/v1/fbsearch/account_serp/", Map.of(
            "query", query,
            "page_token", pageToken
        ));
	}
}
