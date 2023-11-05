package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.friendships.ShowRequest;
import io.github.taz03.jia.responses.friendships.ShowResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class ShowTest {
    @Autowired
    private InstagramClient client;

    @Autowired
    private long instagramPk;

    @Test
    public void showTest() throws Exception {
        ShowRequest request = new ShowRequest(instagramPk);
        ShowResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
