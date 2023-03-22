package io.github.taz03.jia.requests.users;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.users.UserResponse;

public final class UserInfoRequest extends InstagramGetRequest<UserResponse> {
    public UserInfoRequest(long pk) {
        super(UserResponse.class, "/users/" + pk + "/info/");
    }
}
