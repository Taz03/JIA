package io.github.taz03.jia.friendships;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.friendships.FriendshipsRequest;
import io.github.taz03.jia.requests.friendships.FriendshipsRequest.Friendships;
import io.github.taz03.jia.responses.friendships.FriendshipsResponse;

import org.junit.jupiter.api.Test;

public final class FriendshipsTest {
    // pk of official instagram account - https://www.instagram.com/instagram/
    private static final long INSTAGRAM_PK = 25025320;

    @Test
    public void friendshipsFeedFollowingTest() throws Exception {
        FriendshipsRequest followingsRequest = new FriendshipsRequest(INSTAGRAM_PK, Friendships.FOLLOWING);
        FriendshipsResponse followingsResponse = client.sendRequest(followingsRequest).get();

        assertEquals("ok", followingsResponse.getStatus());
    }

    @Test
    public void friendshipsFeedFollowersTest() throws Exception {
        FriendshipsRequest followersRequest = new FriendshipsRequest(INSTAGRAM_PK, Friendships.FOLLOWERS);
        FriendshipsResponse followersResponse = client.sendRequest(followersRequest).get();

        assertEquals("ok", followersResponse.getStatus());
    }
}
