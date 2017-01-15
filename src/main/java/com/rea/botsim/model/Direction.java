package com.rea.botsim.model;

/**
 * Created by sbhowmick on 1/14/17.
 */
public enum Direction {
    NORTH("NORTH"), SOUTH("SOUTH"), EAST("EAST"), WEST("WEST");

    private final String direction;

    Direction(String direction){
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}
