package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram remove profile picture request, used to remove profile picture.
 */
public final class RemoveProfilePictureRequest extends InstagramPostRequest<UserResponse> {
	public RemoveProfilePictureRequest() {
		super(UserResponse.class, "/api/v1/accounts/remove_profile_picture/");
	}
}
