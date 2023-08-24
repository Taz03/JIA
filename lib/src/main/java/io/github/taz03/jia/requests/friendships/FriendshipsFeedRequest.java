package io.github.taz03.jia.requests.friendships;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;

/**
 * Represents an Instagram user friendships feed, used to get user followers or followings
 */
public final class FriendshipsFeedRequest extends InstagramGetRequest<FriendshipsFeedResponse> {
    /**
     * Creates an Instagram friendships feed request
     * @param pk pk of the user
     * @param action action of {@linkplain FriendshipsFeeds} to get followers or followings
     */
    public FriendshipsFeedRequest(long pk, FriendshipsFeeds action) {
        super(FriendshipsFeedResponse.class, String.format("/api/v1/friendships/%s/%s/", pk, action.name().toLowerCase()));
    }

    /**
     * Used to form URL in {@linkplain FriendshipsFeedRequest} constructor
     */
    public enum FriendshipsFeeds{
        FOLLOWERS, FOLLOWING
    }
}
