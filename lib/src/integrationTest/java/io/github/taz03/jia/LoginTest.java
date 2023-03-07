package io.github.taz03.jia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public final class LoginTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/user.csv")
    public void loginTest(String username, String password) {
        InstagramClient client = new InstagramClient(username, password);
        client.login();

        assertNotNull(client.getAuthorization());

        TestClient.setClient(client);
    }
}
