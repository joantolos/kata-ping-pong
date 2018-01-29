package com.joantolos.kata.mars.rover.utils;

public enum Compass {

    NORTH("\u2191"),
    SOUTH("\u2193"),
    WEST("\u2190"),
    EAST("\u2192");

    private String initial;

    Compass(String initial){
        this.initial = initial;
    }

    public String getInitial() {
        return initial;
    }
}
