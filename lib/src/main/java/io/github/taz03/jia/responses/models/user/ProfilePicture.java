package io.github.taz03.jia.responses.models.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ProfilePicture {
    @JsonProperty("url")
    private String url;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;

    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
