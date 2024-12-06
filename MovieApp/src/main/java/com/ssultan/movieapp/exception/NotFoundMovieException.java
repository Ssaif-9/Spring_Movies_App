package com.ssultan.movieapp.exception;

public class NotFoundMovieException extends RuntimeException {
    private String exceptionMessage;

    public NotFoundMovieException() {

    }

    public NotFoundMovieException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public NotFoundMovieException(String message, String exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public NotFoundMovieException(String message, Throwable cause, String exceptionMessage) {
        super(message, cause);
        this.exceptionMessage = exceptionMessage;
    }

    public NotFoundMovieException(Throwable cause, String exceptionMessage) {
        super(cause);
        this.exceptionMessage = exceptionMessage;
    }

    public NotFoundMovieException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String exceptionMessage) {
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
