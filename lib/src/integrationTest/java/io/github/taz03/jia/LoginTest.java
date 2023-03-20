package io.github.taz03.jia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class LoginTest {
    @BeforeAll
    public static void initTestClientUser() throws Exception {
        TestClient.user = new ObjectMapper().readValue(Files.readString(Path.of("src/integrationTest/resources/user.json")), TestClient.User.class);
    }

    @Test
    public void loginTest() throws Exception {
        System.out.println(System.getProperty("verificationCode"));
        assertNotNull(System.getProperty("verificationCode"));
        //InstagramClient client = new InstagramClient(TestClient.user.username(), TestClient.user.password());
        //client.login(() -> new Scanner(System.in).nextLine());

        //assertNotNull(client.getAuthorization());
        //TestClient.client = client;
    }
}
