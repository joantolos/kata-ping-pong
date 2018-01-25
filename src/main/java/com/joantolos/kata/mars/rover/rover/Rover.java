package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.utils.Compass;
import com.joantolos.kata.mars.rover.domain.Position;

public class Rover {

    private MarsMap marsMap;
    private Position currentPosition;
    private Compass currentDirection;

    public Rover(Integer x, Integer y, Compass direction){
        this.currentPosition = new Position(x, y);
        this.currentDirection = direction;
        this.marsMap = new MarsMap(new Position(x, y), direction);
    }

    public Position getPosition() {
        return this.currentPosition;
    }

    protected Position moveForward(Compass direction){
        Position positionProposal = new Position(currentPosition.getX(), currentPosition.getY() + 1);
        if(this.marsMap.isPositionAvailable(positionProposal)){
            this.currentPosition = positionProposal;
            return positionProposal;
        }
        return null;
    }

    protected Boolean moveBackward() {
        return true;
    }

    protected Boolean moveLeft() {
        return true;
    }

    protected Boolean moveRight() {
        return true;
    }
}
