package com.rea.botsim.commands;

import com.rea.botsim.model.Context;

/**
 * Author: Sujay Bhowmick
 * Created Date: 1/15/17
 * Name: Command.java
 * Purpose: Interface for different Robot Commands
 */

public interface Command {

    void execute(Context context);

    public enum CommandType {
        PLACE("PLACE"), MOVE("MOVE"), LEFT("LEFT"), RIGHT("RIGHT"), REPORT("REPORT");

        private String commandType;

        CommandType(String commandType) {
            this.commandType = commandType;
        }

    }
}
