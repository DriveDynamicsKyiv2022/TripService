package com.drivedynamics.tripservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalDefaultExceptionHandler extends ResponseEntityExceptionHandler {
    private static final HttpHeaders headers = new HttpHeaders();

    static {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handle(ValidationException ex, WebRequest request) {
        return handleExceptionInternal(ex, getResponseObject(ex.getMessage(),400,"Bad Request"), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(NoSuchOrderException.class)
    public ResponseEntity<Object> handle(NoSuchOrderException ex, WebRequest request) {
        return handleExceptionInternal(ex, getResponseObject(ex.getMessage(),404,"Not Found"), headers, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handle(ConstraintViolationException ex, WebRequest request) {
        return handleExceptionInternal(ex, getResponseObject(ex.getMessage(),400,"Bad Request"), headers, HttpStatus.BAD_REQUEST, request);
    }

    private ErrorResponse getResponseObject(String message, int status, String error) {
        return new ErrorResponse(LocalDateTime.now(), status, error, message);
    }
}
