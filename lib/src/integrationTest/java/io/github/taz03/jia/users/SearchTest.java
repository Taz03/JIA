package io.github.taz03.jia.users;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.users.SearchRequest;
import io.github.taz03.jia.responses.users.SearchResponse;

public final class SearchTest {
    @Test
    public void accountSerpTest() throws Exception {
        SearchRequest request = new SearchRequest(client.getUsername());
        SearchResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
