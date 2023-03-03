package io.github.taz.java.instagram.api.requests.accounts;

import java.util.Map;

import io.github.taz.java.instagram.api.requests.IgPostRequest;
import io.github.taz.java.instagram.api.responses.IgBaseResponse;

public final class AccountsSetBiographyRequest extends IgPostRequest<IgBaseResponse> {
	public AccountsSetBiographyRequest(String biography) {
		super(IgBaseResponse.class, "/accounts/set_biography/", null, Map.of("raw_text", biography));
	}
}
