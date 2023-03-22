package io.github.taz03.jia.users;

import static io.github.taz03.jia.TestProxy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.users.UserInfoRequest;
import io.github.taz03.jia.responses.UserResponse;

public final class UserInfoTest {
    public void userInfoTest() throws Exception {
        UserInfoRequest request = new UserInfoRequest(client.getPk());
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
