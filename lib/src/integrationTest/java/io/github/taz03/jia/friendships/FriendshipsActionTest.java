package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.LoginTest;
import io.github.taz03.jia.TestProxy;
import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;
import org.junit.jupiter.api.Test;

public class FriendshipsActionTest {
    @Test
    public void followUsernameTest() throws Exception{
        long pk = 25025320;
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(pk, FriendshipsActionRequest.FriendshipsAction.CREATE);
        FriendshipsActionResponse friendshipsActionResponse = TestProxy.client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", friendshipsActionResponse.getStatus());
    }

    @Test
    public void unfollowPkTest() throws Exception{
        long pk = 25025320;
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(pk, FriendshipsActionRequest.FriendshipsAction.DESTROY);
        FriendshipsActionResponse response = TestProxy.client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", response.getStatus());
    }
}
