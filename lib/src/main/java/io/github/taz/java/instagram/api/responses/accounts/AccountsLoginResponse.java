package io.github.taz.java.instagram.api.responses.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.github.taz.java.instagram.api.models.user.User;
import io.github.taz.java.instagram.api.responses.IgBaseResponse;
import io.github.taz.java.instagram.api.responses.IgResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountsLoginResponse implements IgResponse {
    @JsonUnwrapped
    private IgBaseResponse baseResponse;
    @JsonProperty("logged_in_user")
    private User user;
}
