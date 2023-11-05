package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.accounts.EditProfileRequest;
import io.github.taz03.jia.responses.users.UserResponse;
import io.github.taz03.jia.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class EditProfileTest {
    @Autowired
    private User user;

    @Autowired
    private InstagramClient client;

    @Test
    public void editProfileTest() throws Exception {
        EditProfileRequest request = new EditProfileRequest("JIA", "JIA test bio [edit profile request]", user.username(), user.phoneNumber(), user.email(), "");
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
