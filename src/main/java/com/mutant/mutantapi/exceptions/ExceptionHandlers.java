package com.mutant.mutantapi.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(InvalidADNException.class)
    public ResponseEntity<Object> handleInvalidADNException(InvalidADNException e){
        log.error("Invalid ADN sequences");
        RequestException requestException = RequestException.builder().
                advice(e.getAdvice())
                .message(e.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .throwable(e.getCause())
                .build();
        return new ResponseEntity<>(requestException, HttpStatus.FORBIDDEN);
    }
}
