package io.github.taz03.jia.accounts;

import static io.github.taz03.jia.TestProxy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.accounts.EditProfileRequest;
import io.github.taz03.jia.responses.users.UserResponse;

import org.junit.jupiter.api.Test;

public final class EditProfileTest {
    @Test
    public void editProfileTest() throws Exception {
        EditProfileRequest request = new EditProfileRequest("JIA", "JIA test bio [edit profile request]", user.username(), user.phoneNumber(), user.email(), "");
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
