package com.joantolos.kata.mars.rover;

import com.joantolos.kata.mars.rover.domain.Rover;
import com.joantolos.kata.mars.rover.ui.Console;
import com.joantolos.kata.mars.rover.tools.Compass;

import java.io.IOException;
import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) throws IOException {
        Console console = new Console();
        Rover rover = new Rover(0,0, Compass.NORTH, console);
        String commandSequence;

        console.prompt();
        console.print(rover.getMarsMap().printable());
        do {
            console.print("\nEnter your command sequence > ");
            commandSequence = new Scanner(System.in).nextLine();
            if(!commandSequence.equals("exit")) {
                rover.sendSequence(commandSequence);
                console.print(rover.getMarsMap().printable());
            }
        } while (!commandSequence.equals("exit"));
        console.exit();
    }
}
