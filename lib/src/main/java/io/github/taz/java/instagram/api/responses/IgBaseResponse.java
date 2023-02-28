package io.github.taz.java.instagram.api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IgBaseResponse(
    @JsonProperty("status")
    String status,
    @JsonProperty("message")
    String message,
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
