package com.joantolos.kata.mars.rover.ui;

import com.joantolos.kata.mars.rover.domain.Mars;

import java.util.stream.IntStream;

public class UserInterface {

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
        System.out.println("");
        System.out.println("Your rover is located by default at the 0, 0 position and it's facing North.");
        System.out.println("Every run of the program places a maximum of four random obstacles on the planet surface, represented by #");
        System.out.println("Your position on the planet is represented by the initial where the rover is facing (N, S, W or E)");
        return true;
    }

    public Boolean print(String toPrint){
        System.out.println(toPrint);
        return true;
    }

    public Boolean exit() {
        System.out.print("\nBye!\n\n");
        return true;
    }

    public Boolean printMap(String[][] coordinates){
        IntStream.range(0, Mars.SIZE).forEach(currentX -> {
            IntStream.range(0, Mars.SIZE).forEach(currentY -> System.out.print(coordinates[currentX][currentY]));
            System.out.println();
        });
        return true;
    }
}
