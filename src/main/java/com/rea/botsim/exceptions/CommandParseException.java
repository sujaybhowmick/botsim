package com.rea.botsim.exceptions;

/**
 * Author: Sujay Bhowmick
 * Created Date: 1/15/17
 * Name: CommandParseException.java
 * Purpose: Runtime Exception class to represent any parsing exception of Robot commands
 */

public class CommandParseException extends RuntimeException {

    public CommandParseException() {
    }

    public CommandParseException(String message) {
        super(message);
    }

    public CommandParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandParseException(Throwable cause) {
        super(cause);
    }

    public CommandParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
