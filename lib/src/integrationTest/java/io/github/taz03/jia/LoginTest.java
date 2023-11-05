package io.github.taz03.jia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class LoginTest {
    @Autowired
    private InstagramClient client;

    @Test
    public void loginTest() throws Exception {
        client.login(() -> System.getProperty("verificationCode"));
        assertNotNull(client.getAuthorization());
    }
}
