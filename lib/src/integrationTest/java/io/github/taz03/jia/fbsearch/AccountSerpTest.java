package io.github.taz03.jia.fbsearch;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.fbsearch.AccountSerpRequest;
import io.github.taz03.jia.responses.fbsearch.AccountSerpResponse;

public final class AccountSerpTest {
    @Test
    public void accountSerpTest() throws Exception {
        AccountSerpRequest request = new AccountSerpRequest("instagram");
        AccountSerpResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
