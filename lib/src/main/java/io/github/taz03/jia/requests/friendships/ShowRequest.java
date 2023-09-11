package io.github.taz03.jia.requests.friendships;

import io.github.taz03.jia.requests.InstagramGetRequest;
import io.github.taz03.jia.responses.friendships.ShowResponse;

/**
 * Represents an Instagram request, used to show your connection info with others.
 */
public final class ShowRequest extends InstagramGetRequest<ShowResponse> {
    /**
     * Creates an Instagram show request.
     *
     * @param pk pk of the user to show connection info for
     */
    public ShowRequest(long pk) {
        super(ShowResponse.class, "/v1/friendships/show/%d/".formatted(pk));
    }
}
