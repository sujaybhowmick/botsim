package com.rea.botsim.commands;

import com.rea.botsim.exceptions.CommandParseException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Author: Sujay Bhowmick
 * Created Date: 1/15/17
 * Name: CommandParser.java
 * Purpose: Command Parser Class for Robot commands
 */

public class CommandParser {
    private static Map<String, Command> commandLookup = null;
    static {
        commandLookup = new HashMap<>();
        commandLookup.put(Command.CommandType.LEFT.name(), new LeftCommand());
        commandLookup.put(Command.CommandType.RIGHT.name(), new RightCommand());
        commandLookup.put(Command.CommandType.MOVE.name(), new MoveCommand());
        commandLookup.put(Command.CommandType.REPORT.name(), new ReportCommand());
    }

    final static String PLACE_COMMAND_STR_PATTERN = "\\bPLACE\\b";
    final static Pattern PLACE_COMMAND_PATTERN = Pattern.compile(PLACE_COMMAND_STR_PATTERN);

    public static Command parseCommand(String command) {
        if (command != null && PLACE_COMMAND_PATTERN.matcher(command).find()) {
            String[] commandParts = command.split(PLACE_COMMAND_STR_PATTERN);
            Command placeCmd = new PlaceCommand(commandParts[1]);
            return placeCmd;
        }else {
            Command lookupCmd = commandLookup.get(command);
            if(lookupCmd != null){
                return lookupCmd;
            }
            throw new CommandParseException("Invalid Command Provided, please provide a valid command");
        }
    }
}
