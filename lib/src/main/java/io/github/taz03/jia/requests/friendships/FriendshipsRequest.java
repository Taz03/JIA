package io.github.taz03.jia.requests.friendships;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsResponse;

/**
 * Represents an Instagram friendships feed request, used to get followers/followings list.
 * <br><br>
 * To scroll through the results, use the next_max_id received in response of the previous request.
 * <br>
 * Example:
 * {@snippet :
 * FriendshipsRequest followingsRequest = new FriendshipsRequest(pk, Friendships.FOLLOWING);
 * FriendshipsResponse followingsResponse = client.sendRequest(followingsRequest).get();
 *
 * if (followingResponse.getNextMaxId() != 0) {
 *     followingsRequest = new FriendshipsRequest(pk, Friendships.FOLLOWING, followingResponse.getMaxId());
 *     followingsResponse = client.sendRequest(followingsRequest).get();
 * }
 *}
 */
public final class FriendshipsRequest extends InstagramGetRequest<FriendshipsResponse> {
    /**
     * Creates an Instagram friendships feed request.
     *
     * @param pk    pk of the user to get friendships of
     * @param feed {@link Friendships} to get followers or followings
     */
    public FriendshipsRequest(long pk, Friendships feed) {
        this(pk, feed, "");
    }

    /**
     * Creates an Instagram friendships feed request.
     *
     * @param pk    pk of the user to get friendships of
     * @param feed  {@link Friendships} to get followers or followings
     * @param maxId nextMaxId received in the previous response, to fetch after that point
     */
    public FriendshipsRequest(long pk, Friendships feed, String maxId) {
        super(FriendshipsResponse.class, "/api/v1/friendships/%d/%s/".formatted(pk, feed.name().toLowerCase()), Map.of(
            "max_id", maxId
        ));
    }
    
    public enum Friendships {
        FOLLOWERS, FOLLOWING
    }
}
