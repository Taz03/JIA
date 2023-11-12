package io.github.taz03.jia.friendships;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.friendships.ShowManyRequest;
import io.github.taz03.jia.responses.friendships.ShowManyResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class ShowManyTest {
    @Autowired
    private InstagramClient client;

    @Autowired
    private long instagramPk;

    @Test
    public void showManyTest() throws Exception {
        ShowManyRequest request = new ShowManyRequest(instagramPk);
        ShowManyResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
