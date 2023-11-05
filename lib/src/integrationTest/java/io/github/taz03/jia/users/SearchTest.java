package io.github.taz03.jia.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.users.SearchRequest;
import io.github.taz03.jia.responses.users.SearchResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class SearchTest {
    @Autowired
    InstagramClient client;

    @Test
    public void usersSearchTest() throws Exception {
        SearchRequest request = new SearchRequest(client.getUsername());
        SearchResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
