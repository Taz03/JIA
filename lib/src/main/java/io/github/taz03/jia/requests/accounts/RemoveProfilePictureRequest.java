package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram remove profile picture request, used to remove profile picture.
 * <br><br>
 * Endpoint: <i>/accounts/remove_profile_picture/</i>
 */
public final class RemoveProfilePictureRequest extends InstagramPostRequest<UserResponse> {
	public RemoveProfilePictureRequest() {
		super(UserResponse.class, "/accounts/remove_profile_picture/");
	}
}
