package com.rea.botsim;

import com.rea.botsim.model.Direction;
import com.rea.botsim.model.Coordinate;
import com.rea.botsim.model.Position;
import com.rea.botsim.model.SquareTableTop;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sbhowmick on 1/14/17.
 */
public class SquareTableTopTest {
    @Test
    public void testContains1() throws Exception {
        Position position = new Position(new Coordinate(2, 3), Direction.NORTH);

        SquareTableTop tableTop = new SquareTableTop(new Coordinate(0, 0), new Coordinate(5, 5));

        assertTrue(tableTop.contains(position.getCoordinate()));
    }

    @Test
    public void testContains2() throws Exception {
        Position position = new Position(new Coordinate(0, 0), Direction.NORTH);

        SquareTableTop tableTop = new SquareTableTop(new Coordinate(0, 0), new Coordinate(5, 5));

        assertTrue(tableTop.contains(position.getCoordinate()));
    }

    @Test
    public void testContains1False() throws Exception {
        Position position = new Position(new Coordinate(-1, 0), Direction.SOUTH);

        SquareTableTop tableTop = new SquareTableTop(new Coordinate(0, 0), new Coordinate(5, 5));

        assertFalse(tableTop.contains(position.getCoordinate()));
    }


}