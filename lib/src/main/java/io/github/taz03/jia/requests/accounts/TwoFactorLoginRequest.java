package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.LoginResponse;

/**
 * Represents an Instagram login request, used to login into an users account with two factor authorization.
 * <br><br>
 * Endpoint: <i>/accounts/two_factor_login/</i>
 */
public final class TwoFactorLoginRequest extends InstagramPostRequest<LoginResponse> {
	public TwoFactorLoginRequest(String username, String verificationCode, String twoFactorIdentifier) {
		super(LoginResponse.class, "/accounts/two_factor_login/", null, Map.of(
            "username", username,
            "verification_code", verificationCode,
            "two_factor_identifier", twoFactorIdentifier,
            "device_id", "android-a25a335851cf770b"
        ));
	}
}
