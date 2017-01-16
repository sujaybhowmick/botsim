package com.rea.botsim.model;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: Direction.java
 * Purpose: This class represents 4 primary Ordinal Directions in a 2D Plane.
 */

public enum Direction {
    NORTH("NORTH"), SOUTH("SOUTH"), EAST("EAST"), WEST("WEST");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}
