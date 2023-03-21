package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.github.taz03.jia.TestProxy.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.taz03.jia.requests.accounts.SetVisibilityRequest;
import io.github.taz03.jia.requests.accounts.SetVisibilityRequest.Visiblity;
import io.github.taz03.jia.responses.accounts.UserResponse;

public final class SetVisibilityTest {
    @ParameterizedTest
    @MethodSource("getVisiblities")
    public void setVisibilityTest(Visiblity visiblity) throws Exception {
        SetVisibilityRequest request = new SetVisibilityRequest(visiblity);
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
    
    private static List<Visiblity> getVisiblities() {
        return List.of(Visiblity.PUBLIC, Visiblity.PRIVATE);
    }
}
