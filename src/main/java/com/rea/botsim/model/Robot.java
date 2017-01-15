package com.rea.botsim.model;

import com.rea.botsim.commands.Command;
import com.rea.botsim.commands.PlaceCommand;
import com.rea.botsim.exceptions.InvalidPlacementException;

import java.util.Queue;

/**
 * Created by sbhowmick on 1/14/17.
 */
public final class Robot {
    private Context context;


    public Robot(Context context){
        this.context = context;
    }

    public void start() {
        Queue<Command> commandQueue = context.getCommandQueue();
        if(! (commandQueue.peek() instanceof PlaceCommand)){
            System.out.println("Robo is not place on the table, ignoring further commands");
            throw new InvalidPlacementException("Robo not on table");
        }
        while(!commandQueue.isEmpty()){
            Command cmd = commandQueue.poll();
            cmd.execute(context);
        }
    }

    public Position stop(){
        return this.context.getCurrentPosition();
    }

    public void printCommands(){
        Queue<Command> commands = context.getCommandQueue();
        for(Command command: commands){
            System.out.println(command);
        }
    }

}
