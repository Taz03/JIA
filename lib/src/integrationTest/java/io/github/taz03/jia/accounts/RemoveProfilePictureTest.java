package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.github.taz03.jia.TestClient.*;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.accounts.RemoveProfilePictureRequest;
import io.github.taz03.jia.responses.accounts.UserResponse;

public final class RemoveProfilePictureTest {
    @Test
    public void removeProfilePictureTest() throws Exception {
        RemoveProfilePictureRequest request = new RemoveProfilePictureRequest();
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getBaseResponse().getStatus());
    }
}
