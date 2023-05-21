package com.netshoes.api.exceptionhandler;

import java.io.IOException;

import org.jsoup.HttpStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(IOException.class)
    public ResponseEntity<Object> handleIOException(IOException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorResponse error = new ErrorResponse(status.value(), ex.getMessage(), null);

        return new ResponseEntity<>(error, status);
    }

    @ExceptionHandler(HttpStatusException.class)
    protected ResponseEntity<Object> handleHttpStatusException(HttpStatusException ex) {
        HttpStatus status = HttpStatus.valueOf(ex.getStatusCode());

        ErrorResponse error = new ErrorResponse(status.value(), ex.getMessage(), ex.getUrl());

        return new ResponseEntity<>(error, status);
    }
}
