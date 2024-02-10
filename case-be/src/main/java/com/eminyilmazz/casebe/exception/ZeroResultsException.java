package com.eminyilmazz.casebe.exception;


public class ZeroResultsException extends APIStatusException {
    public ZeroResultsException(String message) {
        super(message);
    }
}