package io.github.taz03.jia.friendships;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.friendships.ShowRequest;
import io.github.taz03.jia.responses.friendships.ShowResponse;

import org.junit.jupiter.api.Test;

public final class ShowTest {
    // pk of official instagram account - https://www.instagram.com/instagram/
    private static final long INSTAGRAM_PK = 25025320;

    @Test
    public void showTest() throws Exception {
        ShowRequest request = new ShowRequest(INSTAGRAM_PK);
        ShowResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
