package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.accounts.LoginResponse;

/**
 * Represents an Instagram login request, used to login into an users account.
 * <br><br>
 * Endpoint: <i>/accounts/login</i>
 * <br>
 * Method: POST
 * <br>
 * Response: {@link LoginResponse}
 */
public final class LoginRequest extends InstagramPostRequest<LoginResponse> {
	/**
     * Creates an Instagram login request.
     *
	 * @param username          Instagram username
	 * @param encryptedPassword Instagram encrypted password
	 * @throws Exception        If the passowrd is invalid
	 */
	public LoginRequest(String username, String encryptedPassword) throws Exception {
		super(LoginResponse.class, "/accounts/login/", null, Map.of(
            "username", username,
            "enc_password", encryptedPassword,
            "device_id", "android-a25a335851cf770b",
            "login_attempt_account", 0
        ));
	}
}
