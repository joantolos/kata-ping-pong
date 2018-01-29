package com.joantolos.kata.mars.rover;

import com.joantolos.kata.mars.rover.rover.Rover;
import com.joantolos.kata.mars.rover.ui.Console;
import com.joantolos.kata.mars.rover.utils.Compass;

import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args){
        Console console = new Console();
        Rover rover = new Rover(1,1, Compass.NORTH, console);
        String commandSequence;

        console.prompt();
        console.printMap(rover);
        do {
            console.print("\nEnter your command sequence > ");
            commandSequence = new Scanner(System.in).nextLine();
            if(!commandSequence.equals("exit")) {
                rover.sendSequence(commandSequence);
                console.printMap(rover);
            }
        } while (!commandSequence.equals("exit"));
        console.exit();
    }
}
