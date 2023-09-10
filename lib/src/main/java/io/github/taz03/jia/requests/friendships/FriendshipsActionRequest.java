package io.github.taz03.jia.requests.friendships;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;

/**
 * Represents an Instagram friendships action request, used to follow/unfollow users
 */
public class FriendshipsActionRequest extends InstagramPostRequest<FriendshipsActionResponse> {

    /**
     * Creates an Instagram action request

     * @param pk user's pk to apply the action on him
     * @param action action of {@link FriendshipsAction} to follow or unfollow
     */
    public FriendshipsActionRequest(long pk, FriendshipsAction action){
        super(FriendshipsActionResponse.class, String.format("/api/v1/friendships/%s/%s/", action.name().toLowerCase(), pk));
    }

    public enum FriendshipsAction{
        CREATE, DESTROY
    }
}
