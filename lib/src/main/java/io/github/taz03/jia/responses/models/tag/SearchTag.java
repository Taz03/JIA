package io.github.taz03.jia.responses.models.tag;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SearchTag {
    @JsonProperty("formatted_media_count")
    private String formattedMediaCount;
    @JsonProperty("id")
    private long id;
    @JsonProperty("media_count")
    private long mediaCount;
    @JsonProperty("profile_picture_url")
    private String profilePictureUrl;
    @JsonProperty("search_result_subtitle")
    private String searchResultSubtitle;
    @JsonProperty("use_default_avatar")
    private boolean useDefaultAvatar;

    public String getFormattedMediaCount() {
        return formattedMediaCount;
    }

    public long getId() {
        return id;
    }

    public long getMediaCount() {
        return mediaCount;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getSearchResultSubtitle() {
        return searchResultSubtitle;
    }

    public boolean isUseDefaultAvatar() {
        return useDefaultAvatar;
    }
}
