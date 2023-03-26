package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram remove profile picture request, used to remove profile picture.
 * <br><br>
 * Endpoint: <i>{@value PATH}</i>
 */
public final class RemoveProfilePictureRequest extends InstagramPostRequest<UserResponse> {
    private static final String PATH = "/api/v1/accounts/remove_profile_picture/";

	public RemoveProfilePictureRequest() {
		super(UserResponse.class, PATH);
	}
}
