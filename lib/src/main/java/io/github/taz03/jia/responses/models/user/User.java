package io.github.taz03.jia.responses.models.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class User {
    @JsonUnwrapped
    private Profile profile;
    @JsonProperty("is_business")
    private boolean isBusiness;
    @JsonProperty("media_count")
    private int mediaCount;
    @JsonProperty("follower_count")
    private int followerCount;
    @JsonProperty("following_count")
    private int followingCount;
    @JsonProperty("biography")
    private String biography;
    @JsonProperty("external_url")
    private String externalUrl;
    @JsonProperty("hd_profile_pic_versions")
    private List<ProfilePicture> profilePictureVersions;
    @JsonProperty("hd_profile_pic_url_info")
    private ProfilePicture profilePicture;
    @JsonProperty("account_type")
    private int accountType;

    public Profile getProfile() {
        return profile;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public int getMediaCount() {
        return mediaCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public String getBiography() {
        return biography;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public List<ProfilePicture> getProfilePictureVersions() {
        return profilePictureVersions;
    }

    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    public int getAccountType() {
        return accountType;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
            return this.profile.getUsername().equals(((User) obj).profile.getUsername());
        return (this == obj);
    }

    @Override
    public String toString() {
        return "User{" +
                "profile=" + profile +
                ", isBusiness=" + isBusiness +
                ", mediaCount=" + mediaCount +
                ", followerCount=" + followerCount +
                ", followingCount=" + followingCount +
                ", biography='" + biography + '\'' +
                ", externalUrl='" + externalUrl + '\'' +
                ", profilePictureVersions=" + profilePictureVersions +
                ", profilePicture=" + profilePicture +
                ", accountType=" + accountType +
                '}';
    }
}
