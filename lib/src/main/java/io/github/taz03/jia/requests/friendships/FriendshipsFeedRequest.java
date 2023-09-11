package io.github.taz03.jia.requests.friendships;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;

/**
 * Represents an Instagram friendships feed request, used to get followers/followings list.
 * <br><br>
 * To scroll through the results, use the next_max_id received in response of the previous request.
 * <br>
 * Example:
 * {@snippet :
 * FriendshipsFeedRequest followingsRequest = new FriendshipsFeedRequest(pk, FriendshipsFeeds.FOLLOWING);
 * FriendshipsFeedResponse followingsResponse = client.sendRequest(followingsRequest).get();
 *
 * if (followingResponse.getMaxId() != 0) {
 *     followingsRequest = new FriendshipsFeedRequest(pk, FriendshipsFeeds.FOLLOWING, followingResponse.getMaxId());
 *     followingsResponse = client.sendRequest(followingsRequest).get();
 * }
 * }
 */
public final class FriendshipsFeedRequest extends InstagramGetRequest<FriendshipsFeedResponse> {
    /**
     * Creates an Instagram friendships feed request.
     
     * @param pk    pk of the user to get friendships of
     * @param feed {@link FriendshipsFeeds} to get followers or followings
     */
    public FriendshipsFeedRequest(long pk, FriendshipsFeeds feed) {
        this(pk, feed, 0);
    }

    /**
     * Creates an Instagram friendships feed request.

     * @param pk    pk of the user to get friendships of
     * @param feed  {@link FriendshipsFeeds} to get followers or followings
     * @param maxId beginning number of the followers/followings list
     */
    public FriendshipsFeedRequest(long pk, FriendshipsFeeds feed, int maxId) {
        super(FriendshipsFeedResponse.class, String.format("/api/v1/friendships/%d/%s/", pk, feed.name().toLowerCase()), Map.of(
            "max_id", maxId
        ));
    }
    
    public enum FriendshipsFeeds {
        FOLLOWERS, FOLLOWING
    }
}
