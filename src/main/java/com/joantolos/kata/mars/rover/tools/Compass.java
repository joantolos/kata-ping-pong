package com.joantolos.kata.mars.rover.tools;

public enum Compass {

    NORTH("\u2191"),
    SOUTH("\u2193"),
    WEST("\u2190"),
    EAST("\u2192");

    private String symbol;

    Compass(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
