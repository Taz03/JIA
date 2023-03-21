package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.UserResponse;

/**
 * Represents an Instagram edit profile request, used to edit profile data such as username, phone number, etc.
 * <br><br>
 * Endpoint: <i>/accounts/edit_profile/</i>
 */
public final class EditProfileRequest extends InstagramPostRequest<UserResponse> {
	/**
     * Creates an Instagram edit profile request.
     *
	 * @param name        New display name to set
	 * @param biography   New biography to set
	 * @param username    New username to set
	 * @param phoneNumber Current phone number
	 * @param email       Current email
	 * @param externalUrl New external url to set
	 */
	public EditProfileRequest(String name, String biography, String username, String phoneNumber, String email, String externalUrl) {
		super(UserResponse.class, "/accounts/edit_profile/", null, Map.of(
            "first_name", name,
            "biography", biography,
            "username", username,
            "phone_number", phoneNumber,
            "email", email,
            "external_url", externalUrl
        ));
	}
}
