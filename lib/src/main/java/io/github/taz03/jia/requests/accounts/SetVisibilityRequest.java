package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.UserResponse;

/**
 * Represents an Instagram set visiblity request, used to set visiblity of Instagram account(public or private).
 * <br><br>
 * Endpoint: <i>/accounts/set_public/</i> OR <i>/accounts/set_private</i>
 */
public final class SetVisibilityRequest extends InstagramPostRequest<UserResponse> {
    public static enum Visiblity {
        PUBLIC("set_public/"),
        PRIVATE("set_private/");

        private final String path;

        private Visiblity(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

	/**
     * Creates an Instagram set visiblity request.
     *
	 * @param visiblity The account visiblity to set
	 */
	public SetVisibilityRequest(Visiblity visiblity) {
		super(UserResponse.class, "/accounts/" + visiblity.getPath());
	}
}
