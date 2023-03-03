package io.github.taz.jia.responses.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.github.taz.jia.models.user.User;
import io.github.taz.jia.responses.InstagramBaseResponse;
import io.github.taz.jia.responses.InstagramResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountsLoginResponse implements InstagramResponse {
    @JsonUnwrapped
    private InstagramBaseResponse baseResponse;
    @JsonProperty("logged_in_user")
    private User user;

    public InstagramBaseResponse getBaseResponse() {
        return baseResponse;
    }

    public User getUser() {
        return user;
    }
}
