package io.github.taz03.jia.accounts;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.accounts.RemoveProfilePictureRequest;
import io.github.taz03.jia.responses.users.UserResponse;

import org.junit.jupiter.api.Test;

public final class RemoveProfilePictureTest {
    @Test
    public void removeProfilePictureTest() throws Exception {
        RemoveProfilePictureRequest request = new RemoveProfilePictureRequest();
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
