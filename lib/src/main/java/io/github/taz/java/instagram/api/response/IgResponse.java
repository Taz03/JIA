package io.github.taz.java.instagram.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IgResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private int statusCode;
    @JsonProperty("spam")
    private boolean isSpam;
    @JsonProperty("lock")
    private boolean isLocked;
    @JsonProperty("feedback_title")
    private String feedbackTitle;
    @JsonProperty("feedback_message")
    private String feedbackMessage;
    @JsonProperty("error_type")
    private String errorType;
    @JsonProperty("checkpoint_url")
    private String checkpointUrl;
}
