package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.InstagramResponse;

/**
 * Represents an Instagram set biography request, used to set biography.
 */
public final class SetBiographyRequest extends InstagramPostRequest<InstagramResponse> {
	/**
     * Creates an Instagram set biography request.
     *
	 * @param biography New biography to set
	 */
	public SetBiographyRequest(String biography) {
		super(InstagramResponse.class, "/api/v1/accounts/set_biography/", null, Map.of("raw_text", biography));
	}
}
