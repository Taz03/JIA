package io.github.taz03.jia.friendships;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.friendships.FriendshipsFeedRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;

import org.junit.jupiter.api.Test;

public class FriendshipsFeedTest {
    @Test
    public void friendshipsFeedFollowingTest() throws Exception {
        FriendshipsFeedRequest followingsRequest = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWING);
        FriendshipsFeedResponse followingsResponse = client.sendRequest(followingsRequest).get();

        assertEquals("ok", followingsResponse.getStatus());
    }

    @Test
    public void friendshipsFeedFollowersTest() throws Exception {
        FriendshipsFeedRequest followersRequest = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWERS);
        FriendshipsFeedResponse followersResponse = client.sendRequest(followersRequest).get();

        assertEquals("ok", followersResponse.getStatus());
    }
}
