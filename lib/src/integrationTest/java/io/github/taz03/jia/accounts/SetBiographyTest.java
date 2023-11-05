package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.accounts.SetBiographyRequest;
import io.github.taz03.jia.responses.InstagramResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class SetBiographyTest {
    @Autowired
    private InstagramClient client;

    @Test
    public void setBioTest() throws Exception {
        SetBiographyRequest request = new SetBiographyRequest("Test bio from JIA library!");
        InstagramResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
}
