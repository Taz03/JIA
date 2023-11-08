package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.accounts.LoginResponse;

/**
 * Represents an Instagram login request, used to login into a users account.
 */
public final class LoginRequest extends InstagramPostRequest<LoginResponse> {
	/**
     * Creates an Instagram login request.
     *
	 * @param username          Instagram username
	 * @param encryptedPassword Instagram encrypted password
	 */
	public LoginRequest(String username, String encryptedPassword) {
		super(LoginResponse.class, "/api/v1/accounts/login/", null, Map.of(
            "username", username,
            "enc_password", encryptedPassword,
            "device_id", "android-a25a335851cf770b",
            "login_attempt_account", 0
        ));
	}
}
