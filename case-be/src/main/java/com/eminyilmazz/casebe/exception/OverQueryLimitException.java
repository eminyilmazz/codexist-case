package com.eminyilmazz.casebe.exception;

public class OverQueryLimitException extends APIStatusException {
    public OverQueryLimitException(String message) {
        super(message);
    }
}

