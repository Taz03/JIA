package io.github.taz03.jia.friendships;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.friendships.FriendshipsFeedRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;

import org.junit.jupiter.api.Test;

public class FriendshipsFeedTest {
    @Test
    public void friendshipsFeedFollowingTest() throws Exception {
        FriendshipsFeedRequest friendshipsFeedFollowing = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWING);
        FriendshipsFeedResponse friendshipsFeedFollowingResponse = client.sendRequest(friendshipsFeedFollowing).get();

        assertEquals("ok", friendshipsFeedFollowingResponse.getStatus());
    }

    @Test
    public void friendshipsFeedFollowersTest() throws Exception {
        FriendshipsFeedRequest friendshipsFeedFollowers = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWERS);
        FriendshipsFeedResponse friendshipsFeedFollowersResponse = client.sendRequest(friendshipsFeedFollowers).get();

        assertEquals("ok", friendshipsFeedFollowersResponse.getStatus());
    }
}
