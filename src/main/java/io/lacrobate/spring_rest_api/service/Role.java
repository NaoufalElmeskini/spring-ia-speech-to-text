package io.lacrobate.spring_rest_api.service;

import com.google.gson.annotations.SerializedName;

public enum Role {
    @SerializedName("user")
    USER,

    @SerializedName("system")
    SYSTEM,

    @SerializedName("assistant")
    ASSISTANT
}