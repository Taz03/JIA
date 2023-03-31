package io.github.taz03.jia.requests.users;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.users.UserResponse;

/**
 * Represents an Instagram user info request, used to get details about an Instagram user.
 */
public final class UserInfoRequest extends InstagramGetRequest<UserResponse> {
    /**
     * Creates an Instagram user info request.
     *
     * @param pk pk of the user to get info for
     */
    public UserInfoRequest(long pk) {
        super(UserResponse.class, "/api/v1/users/%s/info/".formatted(pk));
    }
}
