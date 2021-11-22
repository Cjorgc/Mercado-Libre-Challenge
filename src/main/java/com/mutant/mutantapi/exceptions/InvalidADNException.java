package com.mutant.mutantapi.exceptions;

public class InvalidADNException extends RuntimeException{

    private String advice;

    public InvalidADNException(String message) {
        super(message);
        this.advice = "matrix should be square";
    }

    public InvalidADNException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
