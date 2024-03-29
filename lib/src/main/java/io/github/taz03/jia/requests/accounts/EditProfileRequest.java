package io.github.taz03.jia.requests.accounts;

import java.util.HashMap;
import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram edit profile request, used to edit profile data such as username, bio, external url, etc.
 */
public final class EditProfileRequest extends InstagramPostRequest<UserResponse> {
	/**
     * Creates an Instagram edit profile request.
	 * <br>
	 * At least one connected contact is necessary to edit profile data. Other values are optional, can be set to `null`.
     *
	 * @param username    		  New username to set
	 * @param name                New display name to set
	 * @param biography           New biography to set
	 * @param externalUrl         New external url to set
	 * @param showFbLinkOnProfile To show the connected Facebook account on the profile
	 * @param phoneNumber         Current phone number
	 * @param email               Current email
	 */
	public EditProfileRequest(String username, String name, String biography, String externalUrl, Boolean showFbLinkOnProfile, String phoneNumber, String email) {
		super(UserResponse.class, "/api/v1/accounts/edit_profile/", null, makePayload(username, name, biography, externalUrl, showFbLinkOnProfile, phoneNumber, email));
	}

	private static Map<String, Object> makePayload(String username, String name, String biography, String externalUrl, Boolean showFbLinkOnProfile, String phoneNumber, String email) {
		Map<String, Object> payload = new HashMap<>();

		if (username != null) payload.put("username", username);
		if (name != null) payload.put("first_name", name);
		if (biography != null) payload.put("biography", biography);
		if (externalUrl != null) payload.put("external_url", externalUrl);
		if (showFbLinkOnProfile != null) payload.put("show_fb_link_on_profile", showFbLinkOnProfile);
		if (phoneNumber != null) payload.put("phone_number", phoneNumber);
		if (email != null) payload.put("email", email);

		return payload;
	}

	public static class EditProfileRequestBuilder {
		private String username;
		private String name;
		private String biography;
		private String externalUrl;
		private Boolean showFbLinkOnProfile;
		private String phoneNumber;
		private String email;

		public EditProfileRequestBuilder setUsername(String username) {
			this.username = username;
			return this;
		}

		public EditProfileRequestBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public EditProfileRequestBuilder setBiography(String biography) {
			this.biography = biography;
			return this;
		}

		public EditProfileRequestBuilder setExternalUrl(String externalUrl) {
			this.externalUrl = externalUrl;
			return this;
		}

		public EditProfileRequestBuilder setShowFbLinkOnProfile(Boolean showFbLinkOnProfile) {
			this.showFbLinkOnProfile = showFbLinkOnProfile;
			return this;
		}

		public EditProfileRequestBuilder setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public EditProfileRequestBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public EditProfileRequest build() {
			return new EditProfileRequest(username, name, biography, externalUrl, showFbLinkOnProfile, phoneNumber, email);
		}
	}
}
