package com.ssultan.movieapp.exception;

public class AlreadyExistMovieException extends RuntimeException {
    private String messageException;

    public AlreadyExistMovieException(String messageException) {
        this.messageException = messageException;
    }

    public AlreadyExistMovieException(String message, String messageException) {
        super(message);
        this.messageException = messageException;
    }

    public AlreadyExistMovieException(String message, Throwable cause, String messageException) {
        super(message, cause);
        this.messageException = messageException;
    }

    public AlreadyExistMovieException(Throwable cause, String messageException) {
        super(cause);
        this.messageException = messageException;
    }

    public AlreadyExistMovieException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String messageException) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.messageException = messageException;
    }

    public String getMessageException() {
        return messageException;
    }

    public void setMessageException(String messageException) {
        this.messageException = messageException;
    }
}
