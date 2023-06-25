package com.vukm.restapi.exceptions.api;

import com.vukm.restapi.utils.request.FailedRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kieuvu
 * Created on 25/06/2023.
 */
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<FailedRequest> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(new FailedRequest(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<FailedRequest> handleApiException(ApiException ex) {
        return ResponseEntity.status(ex.getStatus())
                             .body(new FailedRequest(ex.getStatus(), ex.getInfo()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FailedRequest> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();

        ex.getBindingResult()
          .getAllErrors()
          .forEach(error -> {
              errorMessages.add(error.getDefaultMessage());
          });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new FailedRequest(HttpStatus.BAD_REQUEST, errorMessages));
    }
}