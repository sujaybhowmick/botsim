package com.rea.botsim.commands;

import com.rea.botsim.model.Context;
import com.rea.botsim.model.Coordinate;
import com.rea.botsim.model.Direction;
import com.rea.botsim.model.Position;

/**
 * Created by sbhowmick on 1/15/17.
 */
public final class MoveCommand implements Command {
    public final CommandType commandType = CommandType.MOVE;

    @Override
    public void execute(Context context) {
        Position oldPosition = context.getCurrentPosition();
        Direction direction = oldPosition.getDirection();
        Coordinate coordinate = oldPosition.getCoordinate();
        Coordinate newCoordinate = null;
        switch (direction) {
            case NORTH: {
                newCoordinate = new Coordinate(coordinate.getX(), coordinate.getY() + 1);
                break;
            }
            case WEST: {
                newCoordinate = new Coordinate(coordinate.getX() - 1, coordinate.getY());
                break;
            }
            case SOUTH: {
                newCoordinate = new Coordinate(coordinate.getX(), coordinate.getY() - 1);
                context.setCurrentPosition(new Position(newCoordinate, direction));
                break;
            }
            case EAST: {
                newCoordinate = new Coordinate(coordinate.getX() + 1, coordinate.getY());
            }
            default:
                break;
        }
        if (context.isOnSquareTable(newCoordinate)) {
            context.setCurrentPosition(new Position(newCoordinate, direction));
        }
    }

    @Override
    public String toString() {
        return commandType.toString();
    }
}
