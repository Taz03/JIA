package io.github.taz03.jia.requests.friendships;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;

/**
 * Represents an Instagram friendships feed request, used to get user's followers or followings
 */
public final class FriendshipsFeedRequest extends InstagramGetRequest<FriendshipsFeedResponse>   {
    /**
     * Creates an Instagram friendships feed request
     
     * @param pk pk of the user to get friendships of
     * @param action action of {@link FriendshipsFeeds} to get followers or followings
     */
    public FriendshipsFeedRequest(long pk, FriendshipsFeeds action) {
        this(pk,  action, 0);
    }

    /**
     * Creates an Instagram friendships feed request with maxId

     * @param pk pk of the user to get friendships of
     * @param action action of {@link FriendshipsFeeds} to get followers or followings
     * @param maxId value defines from which page the feed should start
     */
    public FriendshipsFeedRequest(long pk, FriendshipsFeeds action, String maxId) {
        super(FriendshipsFeedResponse.class, String.format("/api/v1/friendships/%d/%s/", pk, action.name().toLowerCase(), Map.of(
            "max_id", maxId
        ));
    }

    /**
     * Used to form URL in {@linkplain FriendshipsFeedRequest} constructor
     */
    public enum FriendshipsFeeds{
        FOLLOWERS, FOLLOWING
    }
}
