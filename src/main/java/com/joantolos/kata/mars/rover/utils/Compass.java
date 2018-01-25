package com.joantolos.kata.mars.rover.utils;

public enum Compass {

    NORTH("N"),
    SOUTH("S"),
    WEST("W"),
    EAST("E");

    private String initial;

    Compass(String initial){
        this.initial = initial;
    }

    public String getInitial() {
        return initial;
    }
}
