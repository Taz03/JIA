package io.github.taz03.jia.responses.rupload;

import io.github.taz03.jia.responses.InstagramResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
