package com.rea.botsim.model;

import com.rea.botsim.commands.Command;
import com.rea.botsim.commands.CommandParser;
import com.rea.botsim.commands.PlaceCommand;
import com.rea.botsim.exceptions.CommandParseException;
import com.rea.botsim.exceptions.InvalidPlacementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by sbhowmick on 1/15/17.
 */
public class RobotTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidMoves1() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 0,0,NORTH");
        commands.add("MOVE");
        commands.add("REPORT");
        Context context = createContext(commands);
        Robot robot = new Robot(context);
        robot.start();
        Position actual = robot.stop();
        Position expected = new Position(new Coordinate(0, 1), Direction.NORTH);
        assertEquals(expected, actual);

    }

    @Test
    public void testValidMoves2() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 0,0,NORTH");
        commands.add("LEFT");
        commands.add("REPORT");
        Context context = createContext(commands);
        Robot robot = new Robot(context);
        robot.start();
        Position actual = robot.stop();
        Position expected = new Position(new Coordinate(0, 0), Direction.WEST);
        assertEquals(expected, actual);

    }

    @Test
    public void testValidMoves3() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 1,2,EAST");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("LEFT");
        commands.add("MOVE");
        commands.add("REPORT");
        Context context = createContext(commands);
        Robot robot = new Robot(context);
        robot.start();
        Position actual = robot.stop();
        Position expected = new Position(new Coordinate(3, 3), Direction.NORTH);
        assertEquals(expected, actual);

    }

    @Test
    public void testInvalidCommandSequence() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("MOVE");
        commands.add("REPORT");
        Context context = createContext(commands);
        try {
           startStopRobot(context);
            fail();
        }catch(Exception e){
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidCommand() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 1,2,WEST");
        commands.add("REPORTS");
        try {
            Context context = createContext(commands);
            startStopRobot(context);
            fail();
        }catch(CommandParseException e){
            assertTrue(true);
        }
    }

    @Test
    public void testOutsideBoundary() throws Exception {
        List<String> commands = new ArrayList<>();
        commands.add("PLACE 4,4, NORTH");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("RIGHT");
        commands.add("MOVE");
        commands.add("REPORT");
        Context context = createContext(commands);
        Robot robot = new Robot(context);
        robot.start();
        Position actual = robot.stop();
        Position expected = new Position(new Coordinate(4, 4), Direction.EAST);
        assertEquals(expected, actual);
    }

    private Context createContext(List<String> commands){
        SquareTableTop squareTableTop = new SquareTableTop(new Coordinate(0, 0), new Coordinate(5, 5));

        Queue<Command> commandQueue = new LinkedList<>();

        for(String command: commands){
            Command cmd = CommandParser.parseCommand(command);
            commandQueue.add(cmd);
        }

        return new Context(squareTableTop, commandQueue);
    }

    private void startStopRobot(Context context) {
        Robot robot = new Robot(context);
        robot.start();
        Position actual = robot.stop();
    }
}