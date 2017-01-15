package com.rea.botsim.model;

/**
 * Created by sbhowmick on 1/14/17.
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
