package io.github.taz.java.instagram.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IgPayload extends IgBaseModel {
    private String csrfToken;
    private String id;
    private String uid;
    private String uuid;
    private String guid;
    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("phone_id")
    private String phoneId;
}
