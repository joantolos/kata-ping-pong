package com.joantolos.kata.mars.rover.domain;

import java.util.Objects;
import java.util.stream.Stream;

public enum Movements {

    FORWARD("forward", "f"),
    BACKWARD("backward", "b"),
    NORTH("north", "n"),
    SOUTH("south", "s"),
    EAST("east", "e"),
    WEST("west", "w");

    private String name;
    private String command;

    Movements(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public static Movements byCommand(String targetCommand) {
        return Stream.of(Movements.values())
                .filter(f -> f.command.equals(targetCommand))
                .findFirst()
                .orElse(null);
    }

    public static String getCommand(String name) {
        return Objects.requireNonNull(Stream.of(Movements.values())
                .filter(f -> f.name.equals(name))
                .findFirst()
                .orElse(null)).command;
    }
}