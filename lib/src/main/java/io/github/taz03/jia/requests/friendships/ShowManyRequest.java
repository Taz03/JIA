package io.github.taz03.jia.requests.friendships;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.friendships.ShowManyResponse;

/**
 * Represents an Instagram show many request, used to show multiple connections in same request.
 *
 * @see io.github.taz03.jia.requests.friendships.ShowRequest
 */
public final class ShowManyRequest extends InstagramPostRequest<ShowManyResponse> {
    /**
     * Creates an Instagram show many request.
     *
     * @param userIds pk of the users to show the connections to
     */
    public ShowManyRequest(long... userIds) {
        super(ShowManyResponse.class, "/api/v1/friendships/show_many/", null, Map.of(
            "user_ids", Arrays.stream(userIds).mapToObj(String::valueOf).collect(Collectors.joining(","))
        ));
    }
}
