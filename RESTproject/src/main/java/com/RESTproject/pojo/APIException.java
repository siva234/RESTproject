package com.RESTproject.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class APIException {
    @JsonProperty("status")
    private final HttpStatus status;

    @JsonProperty("code")
    private final int code;

    @JsonProperty("reason")
    private final String reason;

    public APIException(HttpStatus status, int code, String message) {
        this.status = status;
        this.code = code;
        this.reason = message;
    }

    public APIException(HttpStatus status, String message) {
        this(status, status.value(), message);
    }

}