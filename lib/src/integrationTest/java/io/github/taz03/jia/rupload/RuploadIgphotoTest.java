package io.github.taz03.jia.rupload;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import io.github.taz03.jia.requests.rupload.RuploadIgphotoRequest;
import io.github.taz03.jia.responses.InstagramResponse;

import org.junit.jupiter.api.Test;

public final class RuploadIgphotoTest {
    @Test
    public void ruploadIgphotoTest() throws Exception {
        RuploadIgphotoRequest request = new RuploadIgphotoRequest(Path.of("src/integrationTest/resources/profile.png"));
        InstagramResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
