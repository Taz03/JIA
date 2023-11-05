package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest;
import io.github.taz03.jia.requests.friendships.FriendshipsActionRequest.Action;
import io.github.taz03.jia.responses.friendships.FriendshipsActionResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class FriendshipsActionTest {
    @Autowired
    private InstagramClient client;

    @Autowired
    private long instagramPk;

    @Test
    public void followUsernameTest() throws Exception {
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(instagramPk, Action.CREATE);
        FriendshipsActionResponse friendshipsActionResponse = client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", friendshipsActionResponse.getStatus());
    }

    @Test
    public void unfollowPkTest() throws Exception {
        FriendshipsActionRequest friendshipsActionRequest = new FriendshipsActionRequest(instagramPk, Action.DESTROY);
        FriendshipsActionResponse friendshipsActionResponse = client.sendRequest(friendshipsActionRequest).get();

        assertEquals("ok", friendshipsActionResponse.getStatus());
    }
}
