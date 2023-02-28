package io.github.taz.java.instagram.api.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProfilePicture(
    @JsonProperty("url")
    String url,
    @JsonProperty("width")
    int width,
    @JsonProperty("height")
    int height
) {}
