package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram edit profile request, used to edit profile data such as username, phone number, etc.
 */
public final class EditProfileRequest extends InstagramPostRequest<UserResponse> {
	/**
     * Creates an Instagram edit profile request.
	 * <p>
	 * At least one connected contact is necessary to edit profile data.
     *
	 * @param username    		  New username to set
	 * @param name                New display name to set
	 * @param biography           New biography to set
	 * @param externalUrl         New external url to set
	 * @param showFbLinkOnProfile To show the connected Facebook account on the profile
	 * @param phoneNumber         Current phone number
	 * @param email               Current email
	 */
	public EditProfileRequest(String username, String name, String biography, String externalUrl, boolean showFbLinkOnProfile, String phoneNumber, String email) {
		super(UserResponse.class, "/api/v1/accounts/edit_profile/", null, Map.of(
			"username", username,
            "first_name", name,
            "biography", biography,
			"external_url", externalUrl,
			"show_fb_link_on_profile", showFbLinkOnProfile,
            "phone_number", phoneNumber,
            "email", email
        ));
	}
}
