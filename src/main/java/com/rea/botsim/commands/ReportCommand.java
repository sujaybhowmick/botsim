package com.rea.botsim.commands;

import com.rea.botsim.model.Context;

/**
 * Author: Sujay Bhowmick
 * Created Date: 1/15/17
 * Name: ReportCommand.java
 * Purpose: Robot's Report Command implementation
 */

public class ReportCommand implements Command {
    public final Command.CommandType commandType = Command.CommandType.REPORT;

    @Override
    public void execute(Context context) {
        System.out.println(context.getCurrentPosition());
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}
