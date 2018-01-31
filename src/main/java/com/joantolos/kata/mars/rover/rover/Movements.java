package com.joantolos.kata.mars.rover.rover;

import java.util.stream.Stream;

public enum Movements {

    FORWARD("f"),
    BACKWARD("b"),
    LEFT("l"),
    RIGHT("r"),
    NORTH("n"),
    SOUTH("s"),
    EAST("e"),
    WEST("w");

    private String command;

    Movements(String command) {
        this.command = command;
    }

    public static Movements byCommand(String targetCommand) {
        return Stream.of(Movements.values())
                .filter(f -> f.command.equals(targetCommand))
                .findFirst()
                .orElse(null);
    }
}
