package io.github.taz03.jia.rupload;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.rupload.RuploadIgphotoRequest;
import io.github.taz03.jia.responses.InstagramResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class RuploadIgphotoTest {
    @Autowired
    private InstagramClient client;

    @Test
    public void ruploadIgphotoTest() throws Exception {
        RuploadIgphotoRequest request = new RuploadIgphotoRequest(Path.of("src/integrationTest/resources/profile.png"));
        InstagramResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
