package io.github.taz03.jia.tags;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.tags.SearchRequest;
import io.github.taz03.jia.responses.tags.SearchResponse;

import org.junit.jupiter.api.Test;

public final class SearchTest {
    @Test
    public void tagsSearchTest() throws Exception {
        SearchRequest request = new SearchRequest("instagram");
        SearchResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
