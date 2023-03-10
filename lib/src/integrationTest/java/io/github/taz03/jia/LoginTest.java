package io.github.taz03.jia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class LoginTest {
    @Test
    public void loginTest() throws Exception {
        TestClient.user = new ObjectMapper().readValue(Files.readString(Path.of("src/integrationTest/resources/user.json")), TestClient.User.class);

        InstagramClient client = new InstagramClient(TestClient.user.username(), TestClient.user.password());
        client.login();

        assertNotNull(client.getAuthorization());
        TestClient.client = client;
    }
}
