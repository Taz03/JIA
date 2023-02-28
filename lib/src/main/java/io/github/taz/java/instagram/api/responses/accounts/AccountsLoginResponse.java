package io.github.taz.java.instagram.api.responses.accounts;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import io.github.taz.java.instagram.api.models.user.User;
import io.github.taz.java.instagram.api.responses.IgBaseResponse;
import io.github.taz.java.instagram.api.responses.IgResponse;

public record AccountsLoginResponse(
    @JsonUnwrapped
    IgBaseResponse baseResponse,
    @JsonProperty("logged_in_user")
    User user
) implements IgResponse {}
