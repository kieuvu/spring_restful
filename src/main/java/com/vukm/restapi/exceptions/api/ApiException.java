package com.vukm.restapi.exceptions.api;

import org.springframework.http.HttpStatus;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public class ApiException extends RuntimeException {

    private final HttpStatus status;
    private final Object     info;

    public ApiException(HttpStatus status, Object info) {
        this.info   = info;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public Object getInfo() {
        return this.info;
    }
}