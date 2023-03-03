package io.github.taz.java.instagram.api.requests.accounts;

import java.util.Map;

import io.github.taz.java.instagram.api.requests.IgPostRequest;
import io.github.taz.java.instagram.api.responses.accounts.AccountsLoginResponse;

public final class AccountsLoginRequest extends IgPostRequest<AccountsLoginResponse> {
	public AccountsLoginRequest(String username, String encryptedPassword) throws Exception {
		super(AccountsLoginResponse.class, "/accounts/login/", null, Map.of(
            "username", username,
            "enc_password", encryptedPassword,
            "device_id", "android-a25a335851cf770b",
            "login_attempt_account", 0
        ));
	}
}
