package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.accounts.AccountsLoginResponse;

/**
 * Represents an Instagram login request, used to login into an users account.
 * <br><br>
 * Endpoint: <i>/accounts/login</i>
 * <br>
 * Method: POST
 * <br>
 * Response: {@link AccountsLoginResponse}
 */
public final class AccountsLoginRequest extends InstagramPostRequest<AccountsLoginResponse> {
	/**
     * Creates an Instagram login request.
     *
	 * @param username          Instagram username
	 * @param encryptedPassword Instagram encrypted password
	 * @throws Exception        If the passowrd is invalid
	 */
	public AccountsLoginRequest(String username, String encryptedPassword) throws Exception {
		super(AccountsLoginResponse.class, "/accounts/login/", null, Map.of(
            "username", username,
            "enc_password", encryptedPassword,
            "device_id", "android-a25a335851cf770b",
            "login_attempt_account", 0
        ));
	}
}
