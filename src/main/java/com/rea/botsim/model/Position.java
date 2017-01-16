package com.rea.botsim.model;

import java.util.Objects;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: Position.java
 * Purpose: This class encapsulates the concept of location of the Robot at any given point in a plane. Position is
 * composed of Coordinate and Ordinal Direction. Two Position are equal if they have same Coordinates and
 * Ordinal Direction
 */

public final class Position {

    private final Coordinate coordinate;

    private Direction direction;

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return coordinate.getX() + "," + coordinate.getY() + "," + direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return Objects.equals(coordinate, position.getCoordinate()) &&
                Objects.equals(direction, position.getDirection());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(coordinate);
        result = 31 * result + Objects.hashCode(direction);
        return result;
    }
}
