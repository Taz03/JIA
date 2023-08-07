package io.github.taz03.jia.accounts;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import io.github.taz03.jia.requests.accounts.CurrentUserRequest;
import io.github.taz03.jia.responses.users.UserResponse;

import org.junit.jupiter.api.Test;

public final class CurrentUserTest {
    @Test
    public void currentUserTest() throws ExecutionException, InterruptedException {
        CurrentUserRequest request = new CurrentUserRequest();
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
