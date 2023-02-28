package io.github.taz.java.instagram.api.models.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public record User(
    @JsonUnwrapped
    Profile profile,
    @JsonProperty("is_business")
    boolean isBusiness,
    @JsonProperty("media_count")
    int mediaCount,
    @JsonProperty("follower_count")
    int followerCount,
    @JsonProperty("following_count")
    int followingCount,
    @JsonProperty("biography")
    String biography,
    @JsonProperty("external_url")
    String externalUrl,
    @JsonProperty("hd_profile_pic_versions")
    List<ProfilePicture> profilePictureVersions,
    @JsonProperty("hd_profile_pic_url_info")
    ProfilePicture profilePicture,
    @JsonProperty("account_type")
    int accountType
) {}
