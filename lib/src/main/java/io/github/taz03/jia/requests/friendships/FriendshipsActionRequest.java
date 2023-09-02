package io.github.taz03.jia.requests.friendships;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;

public class FriendshipsActionRequest extends InstagramPostRequest<FriendshipsActionResponse> {

    public FriendshipsActionRequest(long pk, FriendshipsAction action){
        super(FriendshipsActionResponse.class, String.format("/api/v1/friendships/%s/%s/", action.name().toLowerCase(), pk));
    }

    public enum FriendshipsAction{
        CREATE, DESTROY
    }
}
