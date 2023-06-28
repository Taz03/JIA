package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram set visibility request, used to set visibility of Instagram account(public or private).
 */
public final class SetVisibilityRequest extends InstagramPostRequest<UserResponse> {
    public enum Visibility {
        PUBLIC("set_public/"),
        PRIVATE("set_private/");

        private final String path;

        Visibility(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
    
	/**
     * Creates an Instagram set visibility request.
     *
	 * @param visibility The account visibility to set
	 */
	public SetVisibilityRequest(Visibility visibility) {
		super(UserResponse.class, "/api/v1/accounts/" + visibility.getPath());
	}
}
