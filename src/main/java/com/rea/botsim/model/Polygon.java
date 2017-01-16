package com.rea.botsim.model;

/**
 * Author: Sujay Bhowmick.
 * Created Date: 1/14/17.
 * Name: Polygon.java
 * Purpose: This class represents a Polygon. This is abstract class and shapes such as Square and Rectangle can extends
 * this and provide more concrete implementations.
 */

public abstract class Polygon {
    abstract boolean contains(Coordinate p);
}
