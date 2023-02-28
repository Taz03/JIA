package io.github.taz.java.instagram.api.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Profile(
    @JsonProperty("username")
    String username,
    @JsonProperty("full_name")
    String fullName,
    @JsonProperty("is_private")
    boolean isPrivate,
    @JsonProperty("profile_pid_url")
    String profileUrl,
    @JsonProperty("profile_pic_id")
    String profileId,
    @JsonProperty("is_verified")
    boolean isVerified,
    @JsonProperty("has_anonymous_profile_picture")
    boolean hasAnonymousProfile,
    @JsonProperty("pk")
    long pk
) {}
