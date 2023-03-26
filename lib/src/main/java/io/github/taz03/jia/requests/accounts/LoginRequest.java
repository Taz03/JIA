package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.accounts.LoginResponse;

/**
 * Represents an Instagram login request, used to login into an users account.
 * <br><br>
 * Endpoint: <i>{@value PATH}</i>
 */
public final class LoginRequest extends InstagramPostRequest<LoginResponse> {
    private static final String PATH = "/api/v1/accounts/login/";

	/**
     * Creates an Instagram login request.
     *
	 * @param username          Instagram username
	 * @param encryptedPassword Instagram encrypted password
	 * @throws Exception        If the passowrd is invalid
	 */
	public LoginRequest(String username, String encryptedPassword) throws Exception {
		super(LoginResponse.class, PATH, null, Map.of(
            "username", username,
            "enc_password", encryptedPassword,
            "device_id", "android-a25a335851cf770b",
            "login_attempt_account", 0
        ));
	}
}
