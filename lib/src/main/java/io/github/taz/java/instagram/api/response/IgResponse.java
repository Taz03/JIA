package io.github.taz.java.instagram.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public record IgResponse(
    String status,
    String message,
    @JsonIgnore
    int statusCode,
    @JsonProperty("spam")
    boolean isSpam,
    @JsonProperty("lock")
    boolean isLocked,
    @JsonProperty("feedback_title")
    String feedbackTitle,
    @JsonProperty("feedback_message")
    String feedbackMessage,
    @JsonProperty("error_type")
    String errorType,
    @JsonProperty("checkpoint_url")
    String checkpointUrl
) {}
