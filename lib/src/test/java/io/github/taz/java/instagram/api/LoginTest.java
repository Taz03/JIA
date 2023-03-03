package io.github.taz.java.instagram.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.taz.java.instagram.api.requests.accounts.AccountsSetBiographyRequest;
import io.github.taz.java.instagram.api.responses.IgBaseResponse;

public class LoginTest {
    @Test
    public void loginTest() throws Exception {
        IgClient client = new IgClient("", "", "");

        IgBaseResponse setBioResponse = client.sendRequest(new AccountsSetBiographyRequest("my instagram library jia")).join();

        assertEquals("ok", setBioResponse.getStatus());
    }
}
