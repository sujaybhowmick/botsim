package com.rea.botsim.exceptions;

/**
 * Author: Sujay Bhowmick
 * Created Date: 1/15/17
 * Name: InvalidPlacementException.java
 * Purpose: Runtime Exception class to represent invalid initial Placement location of the Robot
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
