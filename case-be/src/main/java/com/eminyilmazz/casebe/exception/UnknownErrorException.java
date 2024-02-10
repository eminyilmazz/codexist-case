package com.eminyilmazz.casebe.exception;

public class UnknownErrorException extends APIStatusException {
    public UnknownErrorException(String message) {
        super(message);
    }
}