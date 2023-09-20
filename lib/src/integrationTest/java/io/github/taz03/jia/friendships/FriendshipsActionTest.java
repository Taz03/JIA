package io.github.taz03.jia.friendships;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest;
import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest.Action;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;

import org.junit.jupiter.api.Test;

public class FriendshipsActionTest {
    // pk of official instagram account - https://www.instagram.com/instagram/
    private static final long INSTAGRAM_PK = 25025320;

    @Test
    public void followUsernameTest() throws Exception {
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(INSTAGRAM_PK, Action.CREATE);
        FriendshipsActionResponse friendshipsActionResponse = client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", friendshipsActionResponse.getStatus());
    }

    @Test
    public void unfollowPkTest() throws Exception{
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(INSTAGRAM_PK, Action.DESTROY);
        FriendshipsActionResponse friendshipsActionResponse = client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", friendshipsActionResponse.getStatus());
    }
}
