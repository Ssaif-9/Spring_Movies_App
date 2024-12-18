package com.ssultan.movieapp.exception;

public class AlreadyExistMovieException extends RuntimeException {
    private String exceptionMessage;

    public AlreadyExistMovieException(String messageException) {
        this.exceptionMessage = messageException;
    }

    public AlreadyExistMovieException(String message, String messageException) {
        super(message);
        this.exceptionMessage = messageException;
    }

    public AlreadyExistMovieException(String message, Throwable cause, String messageException) {
        super(message, cause);
        this.exceptionMessage = messageException;
    }

    public AlreadyExistMovieException(Throwable cause, String messageException) {
        super(cause);
        this.exceptionMessage = messageException;
    }

    public AlreadyExistMovieException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String messageException) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionMessage = messageException;
    }

    public String getMessageException() {
        return exceptionMessage;
    }

    public void setMessageException(String messageException) {
        this.exceptionMessage = messageException;
    }
}
