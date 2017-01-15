package com.rea.botsim;

import com.rea.botsim.model.Direction;
import com.rea.botsim.model.Coordinate;
import com.rea.botsim.model.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sbhowmick on 1/14/17.
 */
public class PositionTest {
    @Test
    public void testPositionNotEquals() throws Exception {
        Coordinate point12 = new Coordinate(1, 2);

        Position position12N = new Position(point12, Direction.NORTH);

        Coordinate point23 = new Coordinate(2, 3);

        Position position23S = new Position(point23, Direction.SOUTH);

        assertFalse(position12N.equals(position23S));

        assertNotEquals(position12N.hashCode(), position23S.hashCode());


    }

    @Test
    public void testPositionEquals() throws Exception {
        Coordinate point12 = new Coordinate(1, 2);

        Position position12N = new Position(point12, Direction.NORTH);

        Position position12NSame = new Position(point12, Direction.NORTH);

        assertTrue(position12N.equals(position12NSame));

        assertEquals(position12N.hashCode(), position12NSame.hashCode());

    }


    @Test
    public void testToString() throws Exception {
        Coordinate point12 = new Coordinate(1, 2);

        Position position12N = new Position(point12, Direction.NORTH);

        String expected = "1,2,NORTH";

        String unexpected = "2,4,EAST";

        assertEquals(expected, position12N.toString());

        assertNotEquals(unexpected, position12N.toString());
    }

}