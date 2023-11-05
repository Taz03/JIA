package io.github.taz03.jia.accounts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.github.taz03.jia.InstagramClient;
import io.github.taz03.jia.TestConfiguration;
import io.github.taz03.jia.requests.accounts.SetVisibilityRequest;
import io.github.taz03.jia.requests.accounts.SetVisibilityRequest.Visibility;
import io.github.taz03.jia.responses.users.UserResponse;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public final class SetVisibilityTest {
    @Autowired
    private InstagramClient client;

    @ParameterizedTest
    @MethodSource("getVisibilities")
    public void setVisibilityTest(Visibility visibility) throws Exception {
        SetVisibilityRequest request = new SetVisibilityRequest(visibility);
        UserResponse response = client.sendRequest(request).get();

        assertEquals("ok", response.getStatus());
    }
    
    private static List<Visibility> getVisibilities() {
        return List.of(Visibility.PUBLIC, Visibility.PRIVATE);
    }
}
