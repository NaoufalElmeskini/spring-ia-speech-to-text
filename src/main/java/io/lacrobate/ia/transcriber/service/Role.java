package io.lacrobate.ia.transcriber.service;

import com.google.gson.annotations.SerializedName;

public enum Role {
    @SerializedName("user")
    USER,

    @SerializedName("system")
    SYSTEM,

    @SerializedName("assistant")
    ASSISTANT
}