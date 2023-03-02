package io.github.taz.java.instagram.api;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void loginTest() throws Exception {
        IgClient client = new IgClient("", "");
        client.login();

        assertNotEquals("", client.getAuthorization());
    }
}
