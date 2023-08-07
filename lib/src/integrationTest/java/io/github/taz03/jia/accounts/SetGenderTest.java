package io.github.taz03.jia.accounts;

import static io.github.taz03.jia.TestProxy.client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.github.taz03.jia.requests.accounts.SetGenderRequest;
import io.github.taz03.jia.requests.accounts.SetGenderRequest.Gender;
import io.github.taz03.jia.responses.InstagramResponse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public final class SetGenderTest {
    @ParameterizedTest
    @MethodSource("testGenders")
    public void setGenderTest(Object gender) throws Exception {
        SetGenderRequest request;

        switch (gender) {
            case Gender g -> request = new SetGenderRequest(g);
            case String s -> request = new SetGenderRequest(s);
            default -> throw new IllegalArgumentException("Unexpected gender: " + gender.toString());
        }
        InstagramResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }

    public static List<Object> testGenders() {
        return List.of("custom gender", Gender.PREFER_NOT_TO_SAY);
    }
}
