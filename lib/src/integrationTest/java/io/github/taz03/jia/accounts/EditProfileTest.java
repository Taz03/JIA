package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.github.taz03.jia.TestClient.*;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.accounts.EditProfileRequest;
import io.github.taz03.jia.responses.accounts.EditProfileResponse;

public final class EditProfileTest {
    @Test
    public void editProfileTest() throws Exception {
        EditProfileRequest request = new EditProfileRequest("JIA", "JIA test bio [edit profile request]", user.username(), user.phoneNumber(), user.email(), "");
        EditProfileResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getBaseResponse().getStatus());
    }
}
