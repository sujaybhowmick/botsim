package com.rea.botsim.model;

import com.rea.botsim.commands.Command;

import java.util.Queue;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: Context.java
 * Purpose: The Context Class provides the context and state of the Robot as it executes the commands provided.
 */

public final class Context {

    private final SquareTableTop squareTableTop;

    private final Position initialPosition;

    private Position currentPosition;

    private final Queue<Command> commandQueue;

    public Context(SquareTableTop squareTableTop, Position initialPosition,
                   Position currentPosition, Queue<Command> commandQueue) {
        this.squareTableTop = squareTableTop;
        this.initialPosition = initialPosition;
        this.currentPosition = currentPosition;
        this.commandQueue = commandQueue;
    }

    public Context(SquareTableTop squareTableTop, Position initialPosition, Queue<Command> commandQueue) {
        this(squareTableTop, initialPosition, initialPosition, commandQueue);
    }

    public Context(SquareTableTop squareTableTop, Queue<Command> commandQueue) {
        this(squareTableTop, new Position(new Coordinate(0, 0), Direction.NORTH), commandQueue);
    }

    public Position getInitialPosition() {
        return initialPosition;
    }

    public SquareTableTop getSquareTableTop() {
        return squareTableTop;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public boolean isValidPlacement(Coordinate p) {
        return isOnSquareTable(p);
    }

    public Queue<Command> getCommandQueue() {
        return commandQueue;
    }

    public boolean isOnSquareTable(Coordinate p){
        return this.squareTableTop.contains(p);
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
}
