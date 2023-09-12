package io.github.taz03.jia.responses.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
    @JsonProperty("username")
    private String username;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("is_private")
    private boolean isPrivate;
    @JsonProperty("profile_pic_url")
    private String profileUrl;
    @JsonProperty("profile_pic_id")
    private String profileId;
    @JsonProperty("is_verified")
    private boolean isVerified;
    @JsonProperty("has_anonymous_profile_picture")
    private boolean hasAnonymousProfile;
    @JsonProperty("pk")
    private long pk;

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getProfileId() {
        return profileId;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public boolean hasAnonymousProfile() {
        return hasAnonymousProfile;
    }

    public long getPk() {
        return pk;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", isPrivate=" + isPrivate +
                ", profileUrl='" + profileUrl + '\'' +
                ", profileId='" + profileId + '\'' +
                ", isVerified=" + isVerified +
                ", hasAnonymousProfile=" + hasAnonymousProfile +
                ", pk=" + pk +
                '}';
    }
}
