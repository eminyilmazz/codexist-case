package com.eminyilmazz.casebe.exception;

public class InvalidRequestException extends APIStatusException {
    public InvalidRequestException(String message) {
        super(message);
    }
}