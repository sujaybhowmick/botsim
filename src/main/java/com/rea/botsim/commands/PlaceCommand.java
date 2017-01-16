package com.rea.botsim.commands;

import com.rea.botsim.exceptions.InvalidPlacementException;
import com.rea.botsim.model.Context;
import com.rea.botsim.model.Coordinate;
import com.rea.botsim.model.Direction;
import com.rea.botsim.model.Position;

/**
 * Author: Sujay Bhowmick
 * Created Date: 1/15/17
 * Name: PlaceCommand.java
 * Purpose: Robot's Place Command implementation
 */

public class PlaceCommand implements Command {
    public final CommandType commandType = CommandType.PLACE;
    private final String[] parsedArgs;

    public PlaceCommand(String args) {
        this.parsedArgs = parseArgs(args);
    }

    private String[] parseArgs(String args) {

        String[] parsedArgs = args.split(",");
        String[] sanitizedArgs = new String[parsedArgs.length];
        for (int i = 0; i < parsedArgs.length; i++) {
            sanitizedArgs[i] = parsedArgs[i].trim();
        }
        return sanitizedArgs;
    }

    @Override
    public void execute(Context context) {
        int x = Integer.parseInt(this.parsedArgs[0]);
        int y = Integer.parseInt(this.parsedArgs[1]);
        Direction direction = Direction.valueOf(this.parsedArgs[2]);
        Coordinate origin = new Coordinate(x, y);
        Position position = new Position(origin, direction);
        if (context.isValidPlacement(origin)) {
            context.setCurrentPosition(position);
        } else {
            throw new InvalidPlacementException(String.format("Invalid placement position %s", position));
        }
    }

    @Override
    public String toString() {
        return commandType.toString() + " " + parsedArgs[0] + "," + parsedArgs[1] + "," + parsedArgs[2];
    }
}
