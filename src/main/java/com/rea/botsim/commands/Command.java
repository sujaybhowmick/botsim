package com.rea.botsim.commands;

import com.rea.botsim.model.Context;

/**
 * Created by sbhowmick on 1/15/17.
 */
public interface Command {

    void execute(Context context);

    public enum CommandType{
        PLACE("PLACE"), MOVE("MOVE"), LEFT("LEFT"), RIGHT("RIGHT"), REPORT("REPORT");

        private String commandType;

        CommandType(String commandType){
            this.commandType = commandType;
        }

    }
}
