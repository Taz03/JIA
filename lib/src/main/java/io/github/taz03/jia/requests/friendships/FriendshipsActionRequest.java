package io.github.taz03.jia.requests.friendships;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;

/**
 * Represents an Instagram friendships action request, used to follow/unfollow others.
 */
public class FriendshipsActionRequest extends InstagramPostRequest<FriendshipsActionResponse> {
    /**
     * Creates an Instagram friendships action request.
     *
     * @param pk     target user's pk
     * @param action action of {@link Action} to follow or unfollow
     */
    public FriendshipsActionRequest(long pk, Action action){
        super(FriendshipsActionResponse.class, "/api/v1/friendships/%s/%d/".formatted(action.name().toLowerCase(), pk));
    }

    /**
     * CREATE = follow
     * DESTROY = unfollow
     */
    public enum Action {
        CREATE, DESTROY
    }
}
