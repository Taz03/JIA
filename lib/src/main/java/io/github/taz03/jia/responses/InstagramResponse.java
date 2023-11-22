package io.github.taz03.jia.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramResponse {
    @JsonRawValue
    private String json;

    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
    @JsonProperty("spam")
    private boolean isSpam;
    @JsonProperty("feedback_title")
    private String feedbackTitle;
    @JsonProperty("feedback_message")
    private String feedbackMessage;
    @JsonProperty("error_type")
    private String errorType;
    @JsonProperty("checkpoint_url")
    private String checkpointUrl;

    /**
     * @return The raw json response from Instagram
     */
    public String getJson() {
        return json;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getCheckpointUrl() {
        return checkpointUrl;
    }

    @Override
    public String toString() {
        return "InstagramResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", isSpam=" + isSpam +
                ", feedbackTitle='" + feedbackTitle + '\'' +
                ", feedbackMessage='" + feedbackMessage + '\'' +
                ", errorType='" + errorType + '\'' +
                ", checkpointUrl='" + checkpointUrl + '\'' +
                '}';
    }
}
