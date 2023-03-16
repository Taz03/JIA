package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.InstagramBaseResponse;

/**
 * Represents an Instagram set biography request, used to set biography.
 * <br><br>
 * Endpoint: <i>/accounts/set_biography</i>
 */
public final class SetBiographyRequest extends InstagramPostRequest<InstagramBaseResponse> {
	/**
     * Creates an Instagram set biography request.
     *
	 * @param biography New biography to set
	 */
	public SetBiographyRequest(String biography) {
		super(InstagramBaseResponse.class, "/accounts/set_biography/", null, Map.of("raw_text", biography));
	}
}
