package com.RESTproject.pojo;

import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class APIException {
    private final HttpStatus status;
    private final int code;
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