package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram set visiblity request, used to set visiblity of Instagram account(public or private).
 * <br><br>
 * Endpoint: <i>{@value BASE_PATH} + {@value PUBLIC_PATH} OR {@value PRIVATE_PATH}</i>
 */
public final class SetVisibilityRequest extends InstagramPostRequest<UserResponse> {
    private static final String BASE_PATH = "/api/v1/accounts/";
    private static final String PUBLIC_PATH = "set_public/";
    private static final String PRIVATE_PATH = "set_private/";

    public static enum Visiblity {
        PUBLIC(PUBLIC_PATH),
        PRIVATE(PRIVATE_PATH);

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
		super(UserResponse.class, BASE_PATH + visiblity.getPath());
	}
}
