package com.drivedynamics.tripservice.exception;

public class NoSuchOrderException extends RuntimeException {

    public NoSuchOrderException(String message) {
        super(message);
    }
}