package com.vukm.restapi.utils.request;

import org.springframework.http.HttpStatus;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public class FailedRequest {
    private int    statusCode;
    private Object message;

    public FailedRequest() {
    }

    public FailedRequest(Object message) {
        this.message    = message;
        this.statusCode = HttpStatus.BAD_REQUEST.value();
    }

    public FailedRequest(HttpStatus statusCode, Object message) {
        this.statusCode = statusCode.value();
        this.message    = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public FailedRequest setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode.value();
        return this;
    }

    public Object getMessage() {
        return message;
    }

    public FailedRequest setMessage(Object message) {
        this.message = message;
        return this;
    }
}