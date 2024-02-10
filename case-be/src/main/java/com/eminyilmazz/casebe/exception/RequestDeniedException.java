package com.eminyilmazz.casebe.exception;

public class RequestDeniedException extends APIStatusException {
    public RequestDeniedException(String message) {
        super(message);
    }
}