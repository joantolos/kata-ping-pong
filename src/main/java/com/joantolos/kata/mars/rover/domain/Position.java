package com.joantolos.kata.mars.rover.domain;

import java.util.Objects;

public class Position {

    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }

}
