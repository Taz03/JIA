package io.github.taz03.jia.accounts;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.requests.accounts.SetBiographyRequest;
import io.github.taz03.jia.responses.InstagramResponse;

import org.junit.jupiter.api.Test;

public final class SetBiographyTest {
    @Test
    public void setBioTest() throws Exception {
        SetBiographyRequest request = new SetBiographyRequest("Test bio from JIA library!");
        InstagramResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
