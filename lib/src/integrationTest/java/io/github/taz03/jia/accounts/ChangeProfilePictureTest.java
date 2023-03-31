package io.github.taz03.jia.accounts;

import static io.github.taz03.jia.TestProxy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.accounts.ChangeProfilePictureRequest;
import io.github.taz03.jia.requests.rupload.RuploadIgphotoRequest;
import io.github.taz03.jia.responses.rupload.RuploadIgphotoResponse;
import io.github.taz03.jia.responses.users.UserResponse;

public final class ChangeProfilePictureTest {
    @Test
    public void changeProfilePictureTest() throws Exception {
        RuploadIgphotoRequest photoUploadRequest = new RuploadIgphotoRequest(Path.of("src/integrationTest/resources/profile.png"));
        RuploadIgphotoResponse photoUploadResponse = client.sendRequest(photoUploadRequest).get();

        ChangeProfilePictureRequest changeProfileRequest = new ChangeProfilePictureRequest(photoUploadResponse.getUploadId());
        UserResponse changeProfileResponse = client.sendRequest(changeProfileRequest).get();

        assertEquals("ok", changeProfileResponse.getStatus());
    }
}
