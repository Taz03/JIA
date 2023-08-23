package io.github.taz03.jia.requests.users;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.users.FriendshipsFeedResponse;
import io.github.taz03.jia.responses.users.UserResponse;

public final class FriendshipsFeedRequest extends InstagramGetRequest<FriendshipsFeedResponse> {

    public FriendshipsFeedRequest(long pk, FriendshipsFeeds action) {
        super(FriendshipsFeedResponse.class, String.format("/api/v1/friendships/%s/%s/", pk, action.name().toLowerCase()));
    }
    public static enum FriendshipsFeeds{
        FOLLOWERS, FOLLOWING;
    }
}
