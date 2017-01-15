package com.rea.botsim.commands;

import com.rea.botsim.model.Context;
import com.rea.botsim.model.Coordinate;
import com.rea.botsim.model.Direction;
import com.rea.botsim.model.Position;

/**
 * Created by sbhowmick on 1/15/17.
 */
public class RightCommand implements Command {
    public final CommandType commandType = CommandType.RIGHT;

    @Override
    public void execute(Context context) {
        Position oldPosition = context.getCurrentPosition();
        Direction direction = oldPosition.getDirection();
        Coordinate coordinate = oldPosition.getCoordinate();
        switch (direction) {
            case NORTH:
                context.setCurrentPosition(new Position(coordinate, Direction.EAST));
                break;
            case WEST:
                context.setCurrentPosition(new Position(coordinate, Direction.NORTH));
                break;
            case SOUTH:
                context.setCurrentPosition(new Position(coordinate, Direction.EAST));
                break;
            case EAST:
                context.setCurrentPosition(new Position(coordinate, Direction.SOUTH));
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}
