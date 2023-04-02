package io.github.taz03.jia.users;

import static io.github.taz03.jia.TestProxy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.users.UserInfoRequest;
import io.github.taz03.jia.responses.users.UserResponse;

public final class UserInfoTest {
    @Test
    public void userInfoTest() throws Exception {
        UserInfoRequest request = new UserInfoRequest(client.getPk());
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }

    @Test
    public void usernameInfoTest() throws Exception {
        UserInfoRequest request = new UserInfoRequest(client.getUsername());
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
