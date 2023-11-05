package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.accounts.ChangeProfilePictureRequest;
import io.github.taz03.jia.requests.rupload.RuploadIgphotoRequest;
import io.github.taz03.jia.responses.rupload.RuploadIgphotoResponse;
import io.github.taz03.jia.responses.users.UserResponse;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class ChangeProfilePictureTest {
    @Autowired
    private InstagramClient client;

    @Test
    public void changeProfilePictureTest() throws Exception {
        RuploadIgphotoRequest photoUploadRequest = new RuploadIgphotoRequest(Path.of("src/integrationTest/resources/profile.png"));
        RuploadIgphotoResponse photoUploadResponse = client.sendRequest(photoUploadRequest).get();

        ChangeProfilePictureRequest changeProfileRequest = new ChangeProfilePictureRequest(photoUploadResponse.getUploadId());
        UserResponse changeProfileResponse = client.sendRequest(changeProfileRequest).get();

        assertEquals("ok", changeProfileResponse.getStatus());
    }
}
