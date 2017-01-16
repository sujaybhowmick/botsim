package com.rea.botsim.model;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: Coordinate.java
 * Purpose: This class represents a point in a 2D plane. Two points in a plane are same if their x and y coordinates are
 * same.
 */

public final class Coordinate {
    private final int x;

    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate coordinate = (Coordinate) o;

        if (x != coordinate.x) return false;
        return y == coordinate.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
