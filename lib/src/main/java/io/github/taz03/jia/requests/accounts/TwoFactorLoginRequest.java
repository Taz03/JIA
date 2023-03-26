package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.accounts.LoginResponse;

/**
 * Represents an Instagram login request, used to login into an users account with two factor authorization.
 * <br><br>
 * Endpoint: <i>{@value PATH}</i>
 */
public final class TwoFactorLoginRequest extends InstagramPostRequest<LoginResponse> {
    private static final String PATH = "/api/v1/accounts/two_factor_login/";

	public TwoFactorLoginRequest(String username, String verificationCode, String twoFactorIdentifier) {
		super(LoginResponse.class, PATH, null, Map.of(
            "username", username,
            "verification_code", verificationCode,
            "two_factor_identifier", twoFactorIdentifier,
            "device_id", "android-a25a335851cf770b"
        ));
	}
}
