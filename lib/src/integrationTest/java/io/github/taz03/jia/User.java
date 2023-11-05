package io.github.taz03.jia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(
    @JsonProperty("username")
    String username,
    @JsonProperty("password")
    String password,
    @JsonProperty("phone_number")
    String phoneNumber,
    @JsonProperty("email")
    String email
) {}
