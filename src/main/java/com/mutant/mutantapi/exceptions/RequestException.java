package com.mutant.mutantapi.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class RequestException{
    private String message;
    private String advice;
    private Throwable throwable;
    private HttpStatus httpStatus;
}
