package io.github.taz03.jia.requests.accounts;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram current user request, used to get info about current logged in user.
 */
public final class CurrentUserRequest extends InstagramGetRequest<UserResponse> {
    /**
     * Creates an Instagram current user request.
     */
    public CurrentUserRequest() {
        super(UserResponse.class, "/api/v1/accounts/current_user/");
    }
}
