package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.github.taz03.jia.TestProxy.*;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.taz03.jia.requests.accounts.SetVisibilityRequest;
import io.github.taz03.jia.requests.accounts.SetVisibilityRequest.Visibility;
import io.github.taz03.jia.responses.users.UserResponse;

public final class SetVisibilityTest {
    @ParameterizedTest
    @MethodSource("getVisiblities")
    public void setVisibilityTest(Visibility visibility) throws Exception {
        SetVisibilityRequest request = new SetVisibilityRequest(visibility);
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
    
    private static List<Visibility> getVisiblities() {
        return List.of(Visibility.PUBLIC, Visibility.PRIVATE);
    }
}
