package com.rea.botsim.exceptions;

/**
 * Created by sbhowmick on 1/15/17.
 */
public class InvalidPlacementException extends RuntimeException {
    public InvalidPlacementException() {
    }

    public InvalidPlacementException(String message) {
        super(message);
    }

    public InvalidPlacementException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPlacementException(Throwable cause) {
        super(cause);
    }

    public InvalidPlacementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
