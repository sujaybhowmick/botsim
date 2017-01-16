package com.rea.botsim.model;

import com.rea.botsim.commands.Command;
import com.rea.botsim.commands.PlaceCommand;
import com.rea.botsim.exceptions.InvalidPlacementException;

import java.util.Queue;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: Robot.java
 * Purpose: This class represent the Robot. The Robot take the context object as input state. The Robot starts executing
 * the commands after the @see start() method is invoked and @see stop() method will stop the robot and return its
 * current position after executing the commands.
 */

public final class Robot {
    private Context context;

    public Robot(Context context) {
        this.context = context;
    }

    public void start() {
        Queue<Command> commandQueue = context.getCommandQueue();
        if (!(commandQueue.peek() instanceof PlaceCommand)) {
            System.out.println("Robo is not place on the table, ignoring further commands");
            throw new InvalidPlacementException("Robo not on table");
        }
        while (!commandQueue.isEmpty()) {
            Command cmd = commandQueue.poll();
            cmd.execute(context);
        }
    }

    public Position stop() {
        return this.context.getCurrentPosition();
    }

    public void printCommands() {
        Queue<Command> commands = context.getCommandQueue();
        for (Command command : commands) {
            System.out.println(command);
        }
    }
}
