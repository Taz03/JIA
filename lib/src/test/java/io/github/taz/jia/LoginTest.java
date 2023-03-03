package io.github.taz.jia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.taz.jia.requests.accounts.AccountsSetBiographyRequest;
import io.github.taz.jia.responses.InstagramBaseResponse;

public class LoginTest {
    @Test
    public void loginTest() throws Exception {
        InstagramClient client = new InstagramClient("", "");
        client.login();

        InstagramBaseResponse setBioResponse = client.sendRequest(new AccountsSetBiographyRequest("my instagram library jia")).join();

        assertEquals("ok", setBioResponse.getStatus());
    }
}
