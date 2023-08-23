package io.github.taz03.jia.requests.users;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.users.UserResponse;

public final class FriendshipsFeedRequest extends InstagramGetRequest<UserResponse> {

    public FriendshipsFeedRequest(long pk, FriendshipsFeeds action) {
        super(UserResponse.class, String.format("/api/v1/friendships/%s/%s/", pk, action.name().toLowerCase()));
    }
    public static enum FriendshipsFeeds{
        FOLLOWERS, FOLLOWING;
    }
}
