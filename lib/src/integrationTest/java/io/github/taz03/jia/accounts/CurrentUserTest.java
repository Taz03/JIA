package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.accounts.CurrentUserRequest;
import io.github.taz03.jia.responses.users.UserResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class CurrentUserTest {
    @Autowired
    private InstagramClient client;

    @Test
    public void currentUserTest() throws ExecutionException, InterruptedException {
        CurrentUserRequest request = new CurrentUserRequest();
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
