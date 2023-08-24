package io.github.taz03.jia.friendships;

import io.github.taz03.jia.requests.friendships.FriendshipsFeedRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FriendshipsTest {

    @Test
    public void friendshipsFeedFollowingTest() throws ExecutionException, InterruptedException {
        FriendshipsFeedRequest friendshipsFeedFollowing = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWING);
        FriendshipsFeedResponse friendshipsFeedFollowingResponse = client.sendRequest(friendshipsFeedFollowing).get();

        assertEquals("ok", friendshipsFeedFollowingResponse.getStatus());
    }

    @Test
    public void friendshipsFeedFollowersTest() throws ExecutionException, InterruptedException {
        FriendshipsFeedRequest friendshipsFeedFollowers = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWERS);
        FriendshipsFeedResponse friendshipsFeedFollowersResponse = client.sendRequest(friendshipsFeedFollowers).get();

        assertEquals("ok", friendshipsFeedFollowersResponse.getStatus());
    }
}
