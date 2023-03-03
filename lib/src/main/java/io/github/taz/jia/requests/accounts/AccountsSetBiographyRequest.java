package io.github.taz.jia.requests.accounts;

import java.util.Map;

import io.github.taz.jia.requests.InstagramPostRequest;
import io.github.taz.jia.responses.InstagramBaseResponse;

public final class AccountsSetBiographyRequest extends InstagramPostRequest<InstagramBaseResponse> {
	public AccountsSetBiographyRequest(String biography) {
		super(InstagramBaseResponse.class, "/accounts/set_biography/", null, Map.of("raw_text", biography));
	}
}
