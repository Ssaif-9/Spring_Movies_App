package com.ssultan.movieapp.exception;


public class InvalidAccountDataException extends RuntimeException {

    private String exceptionMessage;
    private String exceptionCode;

    public InvalidAccountDataException() {
    }

    public InvalidAccountDataException(String exceptionMessage, String exceptionCode) {
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public InvalidAccountDataException(String message, String exceptionMessage, String exceptionCode) {
        super(message);
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public InvalidAccountDataException(String message, Throwable cause, String exceptionMessage, String exceptionCode) {
        super(message, cause);
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public InvalidAccountDataException(Throwable cause, String exceptionMessage, String exceptionCode) {
        super(cause);
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public InvalidAccountDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionMessage, String exceptionCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
