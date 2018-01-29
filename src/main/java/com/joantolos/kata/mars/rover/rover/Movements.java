package com.joantolos.kata.mars.rover.rover;

public enum Movements {

    FORWARD("f"),
    BACKWARD("b"),
    LEFT("l"),
    RIGHT("r"),
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private String command;

    Movements(String command) {
        this.command = command;
    }
}
