package com.rea.botsim;

/**
 * Author: Sujay Bhowmick.
 * Created Date: on 1/15/17.
 * Name: Main.java
 * Purpose: Entry point to the Robot Simulation program.
 */

public class Main {

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Useage: Main <inputfile>");
            System.exit(1);
        }

        RoboPilot roboPilot = new RoboPilot();
        roboPilot.init(args[0]);
        roboPilot.printInputCommands();
        System.out.println();
        roboPilot.start();
        roboPilot.stop();

    }
}
