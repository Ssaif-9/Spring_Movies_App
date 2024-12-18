package com.ssultan.movieapp.exception;


public class ErrorException {

    private String exceptionMessage;

    public ErrorException() {}

    public ErrorException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

}
