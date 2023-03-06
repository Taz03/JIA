package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.InstagramBaseResponse;

/**
 * Represents an Instagram set biography request, used to set biography of a user.
 * <br><br>
 * Endpoint: <i>/accounts/set_biography</i>
 * <br>
 * Method: POST
 * <br>
 * Response: {@link InstagramBaseResponse}
 */
public final class AccountsSetBiographyRequest extends InstagramPostRequest<InstagramBaseResponse> {
	/**
     * Creates an Instagram set biography request.
     *
	 * @param biography New biography to set
	 */
	public AccountsSetBiographyRequest(String biography) {
		super(InstagramBaseResponse.class, "/accounts/set_biography/", null, Map.of("raw_text", biography));
	}
}
