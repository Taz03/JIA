package io.github.taz03.jia.responses.rupload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.taz03.jia.responses.InstagramResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class RuploadIgphotoResponse extends InstagramResponse {
    @JsonProperty("upload_id")
    private String uploadId;

    public String getUploadId() {
        return uploadId;
    }

    @Override
    public String toString() {
        return "RuploadIgphotoResponse{" +
                "uploadId='" + uploadId + '\'' +
                '}';
    }
}
