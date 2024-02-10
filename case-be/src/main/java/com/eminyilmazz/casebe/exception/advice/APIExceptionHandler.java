package com.eminyilmazz.casebe.exception.advice;

import com.eminyilmazz.casebe.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {
    //TODO: Pointless, too many duplicated code for exceptions
    @ExceptionHandler(APIStatusException.class)
    public ResponseEntity<String> handlePlacesSearchException(APIStatusException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(ZeroResultsException.class)
    public ResponseEntity<String> handleZeroResultsException(ZeroResultsException ex) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(OverQueryLimitException.class)
    public ResponseEntity<String> handleOverQueryLimitException(OverQueryLimitException ex) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(ex.getMessage());
    }

    @ExceptionHandler(RequestDeniedException.class)
    public ResponseEntity<String> handleRequestDeniedException(RequestDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(UnknownErrorException.class)
    public ResponseEntity<String> handleUnknownErrorException(UnknownErrorException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}

