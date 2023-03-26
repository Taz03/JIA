package io.github.taz03.jia.rupload;

import static io.github.taz03.jia.TestProxy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.rupload.RuploadIgphotoRequest;
import io.github.taz03.jia.responses.InstagramResponse;

public final class RuploadIgphotoTest {
    @Test
    public void ruploadIgphotoTest() throws Exception {
        RuploadIgphotoRequest request = new RuploadIgphotoRequest(new File("/home/taz/Pictures/Saved Pictures/profile.png"));
        InstagramResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
