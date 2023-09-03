package io.github.taz03.jia.friendships;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.taz03.jia.requests.friendships.FriendshipsFeedRequest;
import io.github.taz03.jia.responses.friendships.FriendshipsFeedResponse;

import io.github.taz03.jia.responses.models.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FriendshipsFeedTest {
    @Test
    public void friendshipsFeedFollowingTest() throws Exception {
        String maxId;
        List<User> followersList = new ArrayList<>();

        FriendshipsFeedRequest friendshipsFeedFirstRequest = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWING);
        FriendshipsFeedResponse friendshipsFeedFirstResponse = client.sendRequest(friendshipsFeedFirstRequest).get();

        if(friendshipsFeedFirstResponse.getStatus().equals("ok")) {
            followersList.addAll(friendshipsFeedFirstResponse.getUsers());
            maxId = friendshipsFeedFirstResponse.getNextMaxId();

            while (maxId != null) {
                FriendshipsFeedRequest friendshipsFeedPaginatedRequest = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWING, maxId);
                FriendshipsFeedResponse friendshipsFeedPaginatedResponse = client.sendRequest(friendshipsFeedPaginatedRequest).get();
                if (friendshipsFeedPaginatedResponse.getStatus().equals("ok")) {
                    maxId = friendshipsFeedPaginatedResponse.getNextMaxId();
                    followersList.addAll(friendshipsFeedPaginatedResponse.getUsers());
                }
            }
        }

        assertNotNull(followersList);
    }

    @Test
    public void friendshipsFeedFollowersTest() throws Exception {
        String maxId;
        List<User> followersList = new ArrayList<>();

        FriendshipsFeedRequest friendshipsFeedFirstRequest = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWERS);
        FriendshipsFeedResponse friendshipsFeedFirstResponse = client.sendRequest(friendshipsFeedFirstRequest).get();

        if(friendshipsFeedFirstResponse.getStatus().equals("ok")) {
            followersList.addAll(friendshipsFeedFirstResponse.getUsers());
            maxId = friendshipsFeedFirstResponse.getNextMaxId();

            while (maxId != null) {
                FriendshipsFeedRequest friendshipsFeedPaginatedRequest = new FriendshipsFeedRequest(client.getPk(), FriendshipsFeedRequest.FriendshipsFeeds.FOLLOWERS, maxId);
                FriendshipsFeedResponse friendshipsFeedPaginatedResponse = client.sendRequest(friendshipsFeedPaginatedRequest).get();
                if (friendshipsFeedPaginatedResponse.getStatus().equals("ok")) {
                    maxId = friendshipsFeedPaginatedResponse.getNextMaxId();
                    followersList.addAll(friendshipsFeedPaginatedResponse.getUsers());
                }
            }
        }

        assertNotNull(followersList);
    }
}
