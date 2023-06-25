package com.vukm.restapi.exceptions.api;

import org.springframework.http.HttpStatus;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
public class BadRequestException extends ApiException {
    public BadRequestException(Object info) {
        super(HttpStatus.BAD_REQUEST, info);
    }
}