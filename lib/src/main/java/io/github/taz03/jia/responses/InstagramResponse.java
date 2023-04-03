package io.github.taz03.jia.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstagramResponse {
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
}
