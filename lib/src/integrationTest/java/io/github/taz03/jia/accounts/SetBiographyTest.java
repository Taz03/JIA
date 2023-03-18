package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.github.taz03.jia.TestClient.*;

import org.junit.jupiter.api.Test;

import io.github.taz03.jia.requests.accounts.SetBiographyRequest;
import io.github.taz03.jia.responses.InstagramBaseResponse;

public final class SetBiographyTest {
    @Test
    public void setBioTest() throws Exception {
        SetBiographyRequest request = new SetBiographyRequest("Test bio from JIA library!");
        InstagramBaseResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
