package com.rea.botsim.model;

/**
 * Created by sbhowmick on 1/14/17.
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
