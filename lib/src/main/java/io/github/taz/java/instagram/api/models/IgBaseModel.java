package io.github.taz.java.instagram.api.models;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class IgBaseModel {
    @JsonAnySetter
    private Map<String, Object> extraProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getExtraProperties() {
        return extraProperties;
    }

    @JsonIgnore
    public Object getProperty(String key) {
        return extraProperties.get(key);
    }

    public <T extends IgBaseModel> void putProperty(String key, Object value) {
        extraProperties.put(key, value);
    }
}
