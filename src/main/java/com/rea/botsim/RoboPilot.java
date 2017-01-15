package com.rea.botsim;

import com.rea.botsim.commands.Command;
import com.rea.botsim.commands.CommandParser;
import com.rea.botsim.commands.PlaceCommand;
import com.rea.botsim.exceptions.InvalidPlacementException;
import com.rea.botsim.model.Context;
import com.rea.botsim.model.Coordinate;
import com.rea.botsim.model.Robot;
import com.rea.botsim.model.SquareTableTop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sbhowmick on 1/15/17.
 */
public class RoboPilot {

    private Robot robot;

    private List<String> readInput(String fileName){
        List<String> lines = null;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            lines = stream.collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public void init(String inputFile) {
        List<String> commands = readInput(inputFile);
        SquareTableTop squareTableTop = new SquareTableTop(new Coordinate(0, 0), new Coordinate(5, 5));

        Queue<Command> commandQueue = new LinkedList<>();

        for(String command: commands){
            Command cmd = CommandParser.parseCommand(command);
            commandQueue.add(cmd);
        }
        Context context = new Context(squareTableTop, commandQueue);
        robot = new Robot(context);
    }

    public void start(){
        robot.start();
    }

    public void stop(){
        robot.stop();
    }

    public void printInputCommands(){
        robot.printCommands();
    }

}
