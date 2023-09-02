package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.TestProxy;
import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;
import org.junit.jupiter.api.Test;

public class FriendshipsActionTest {
    @Test
    public void unfollowPkTest() throws Exception{
        long pk = 3333; // your pk here
        FriendshipsActionResponse response = TestProxy.client.sendRequest(new FriendshipsActionRequest(pk, FriendshipsActionRequest.FriendshipsAction.DESTROY)).get();
        assertEquals("ok", response.getStatus());
    }

    @Test
    public void followUsernameTest() throws Exception{
        long pk = 3333; // your pk here
        FriendshipsActionResponse response = TestProxy.client.sendRequest(new FriendshipsActionRequest(pk, FriendshipsActionRequest.FriendshipsAction.CREATE)).get();
        assertEquals("ok", response.getStatus());
    }
}
