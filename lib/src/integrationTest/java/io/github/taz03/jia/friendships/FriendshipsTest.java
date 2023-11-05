package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.friendships.FriendshipsRequest;
import io.github.taz03.jia.requests.friendships.FriendshipsRequest.Friendships;
import io.github.taz03.jia.responses.friendships.FriendshipsResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class FriendshipsTest {
    @Autowired
    private InstagramClient client;

    @Autowired
    private long instagramPk;

    @Test
    public void friendshipsFeedFollowingTest() throws Exception {
        FriendshipsRequest followingsRequest = new FriendshipsRequest(instagramPk, Friendships.FOLLOWING);
        FriendshipsResponse followingsResponse = client.sendRequest(followingsRequest).get();

        assertEquals("ok", followingsResponse.getStatus());
    }

    @Test
    public void friendshipsFeedFollowersTest() throws Exception {
        FriendshipsRequest followersRequest = new FriendshipsRequest(instagramPk, Friendships.FOLLOWERS);
        FriendshipsResponse followersResponse = client.sendRequest(followersRequest).get();

        assertEquals("ok", followersResponse.getStatus());
    }
}
