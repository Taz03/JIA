package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.TestProxy;
import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;
import org.junit.jupiter.api.Test;

public class FriendshipsActionTest {
    // pk of official instagram account - https://www.instagram.com/instagram/
    private static final long INSTAGRAM_PK = 25025320;
    @Test
    public void followUsernameTest() throws Exception{
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(INSTAGRAM_PK, FriendshipsActionRequest.FriendshipsAction.CREATE);
        FriendshipsActionResponse friendshipsActionResponse = TestProxy.client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", friendshipsActionResponse.getStatus());
    }

    @Test
    public void unfollowPkTest() throws Exception{
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(INSTAGRAM_PK, FriendshipsActionRequest.FriendshipsAction.DESTROY);
        FriendshipsActionResponse response = TestProxy.client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", response.getStatus());
    }
}
