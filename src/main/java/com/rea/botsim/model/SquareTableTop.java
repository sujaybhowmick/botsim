package com.rea.botsim.model;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: SquareTableTop.java
 * Purpose: This class represents the 2D plane on which the Robot is place and commanded to maneuver. This class extends
 * the Polygon abstract class and provides a concrete implementation of the @see contains(Coordinate p) method.
 */

public class SquareTableTop extends Polygon {

    public Coordinate[] vertices = new Coordinate[4];

    public SquareTableTop(Coordinate lowerLeft, Coordinate upperRight) {
        vertices[0] = lowerLeft;
        vertices[1] = new Coordinate(upperRight.getX(), 0);
        vertices[2] = upperRight;
        vertices[3] = new Coordinate(0, upperRight.getY());
    }

    @Override
    public boolean contains(Coordinate p) {
        boolean inside = false;
        for (int i = 0, j = vertices.length - 1; i < vertices.length; j = i++) {
            if ((vertices[i].getY() > p.getY()) != (vertices[j].getY() > p.getY()) &&
                    (p.getX() < (vertices[j].getX() - vertices[i].getX()) * (p.getY() - vertices[i].getY()) / (vertices[j].getY() - vertices[i].getY()) + vertices[i].getX())) {
                inside = !inside;
            }
        }
        return inside;
    }
}
