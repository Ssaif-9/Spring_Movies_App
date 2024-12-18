package com.ssultan.movieapp.exception;


public class InvalidAccountDataException extends RuntimeException {

    private String exceptionMessage;

    public InvalidAccountDataException() {
    }

    public InvalidAccountDataException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public InvalidAccountDataException(String message, String exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public InvalidAccountDataException(String message, Throwable cause, String exceptionMessage) {
        super(message, cause);
        this.exceptionMessage = exceptionMessage;
    }

    public InvalidAccountDataException(Throwable cause, String exceptionMessage) {
        super(cause);
        this.exceptionMessage = exceptionMessage;
    }

    public InvalidAccountDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }


}
