package com.rea.botsim.commands;

import com.rea.botsim.exceptions.CommandParseException;

import java.util.regex.Pattern;

/**
 * Created by sbhowmick on 1/15/17.
 */
public class CommandParser {
    final static String PLACE_COMMAND_STR_PATTERN = "\\bPLACE\\b";
    final static Pattern PLACE_COMMAND_PATTERN = Pattern.compile(PLACE_COMMAND_STR_PATTERN);
    final static Pattern MOVE_COMMAND_PATTERN = Pattern.compile("\\bMOVE\\b");
    final static Pattern LEFT_COMMAND_PATTERN = Pattern.compile("\\bLEFT\\b");
    final static Pattern RIGHT_COMMAND_PATTERN = Pattern.compile("\\bRIGHT\\b");
    final static Pattern REPORT_COMMAND_PATTERN = Pattern.compile("\\bREPORT\\b");


    public static Command parseCommand(String command) {
        if(command != null && PLACE_COMMAND_PATTERN.matcher(command).find()){
            String[] commandParts = command.split(PLACE_COMMAND_STR_PATTERN);
            Command placeCmd = new PlaceCommand(commandParts[1]);
            return placeCmd;
        }
        if(command != null && MOVE_COMMAND_PATTERN.matcher(command).find()){
            Command moveCmd = new MoveCommand();
            return moveCmd;
        }
        if(command != null && LEFT_COMMAND_PATTERN.matcher(command).find()){
            Command leftCmd = new LeftCommand();
            return leftCmd;
        }
        if(command != null && RIGHT_COMMAND_PATTERN.matcher(command).find()){
            Command rightCmd = new RightCommand();
            return rightCmd;
        }
        if(command != null && REPORT_COMMAND_PATTERN.matcher(command).find()){
            Command reportCmd = new ReportCommand();
            return reportCmd;
        }
        throw new CommandParseException("Invalid Command Provided, please provide a valid command");
    }
}
