package com.joantolos.kata.mars.rover.ui;

import com.joantolos.kata.mars.rover.domain.Mars;

public class Console {

    public Boolean prompt(){
        System.out.println("  __    __     _                           ");
        System.out.println(" / / /\\ \\ \\___| | ___ ___  _ __ ___   ___  ");
        System.out.println(" \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ ");
        System.out.println("  _  /\\  /  __/ | (_| (_) | | | | | |  __/ ");
        System.out.println(" | |_ ___ \\___/\\/\\_______/____|___|_|\\___| ");
        System.out.println(" | __/ _ \\   /    \\ / _` | '__/ __|        ");
        System.out.println(" | || (_) | / /\\/\\ \\ (_| | |  \\__ \\        ");
        System.out.println("  \\__\\___/  \\/    \\/\\__,_|_|  |___/        ");
        System.out.println("                                           ");
        System.out.println("Your rover is located by default at the 0, 0 position and it's facing North.");
        System.out.println("Every run of the program places a maximum of four random obstacles on the planet surface, represented by " + Mars.OBSTACLE);
        System.out.println("Your position on the planet is represented by an arrow pointing where the rover is facing (\u2191, \u2193, \u2190 or \u2192)");
        System.out.println("Type f to go forwards, b to go backwards, N to locate north, S to locate south, E to locate east and W to locate west.");
        System.out.println("Type exit to stop the exploration.");
        System.out.println("Mind the obstacles!");
        System.out.println("");
        return true;
    }

    public Boolean print(String toPrint){
        System.out.println(toPrint);
        return true;
    }

    public Boolean exit() {
        System.out.print("\nDisconnected from Mars rover\n\n");
        return true;
    }

}
