package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.domain.Mars;
import com.joantolos.kata.mars.rover.domain.Position;
import com.joantolos.kata.mars.rover.utils.Compass;

public class Rover {

    private MarsMap marsMap;
    private Position currentPosition;
    private Compass currentDirection;

    public Rover(Integer x, Integer y, Compass direction){
        this.currentPosition = new Position(x, y);
        this.currentDirection = direction;
        this.marsMap = new MarsMap(this.currentPosition, this.currentDirection);
    }

    public Position getPosition() {
        return this.currentPosition;
    }

    protected Boolean move(Movements movement){
        switch (movement) {
            case FORWARD:
                return moveForward();
            case BACKWARD:
                return moveBackward();
            case LEFT:
                return moveLeft();
            case RIGHT:
                return moveRight();
            case NORTH:
                this.currentDirection = Compass.NORTH;
            case SOUTH:
                this.currentDirection = Compass.SOUTH;
            case EAST:
                this.currentDirection = Compass.EAST;
            case WEST:
                this.currentDirection = Compass.WEST;
        }
        return false;
    }

    private Boolean moveForward(){
        Position positionProposal;
        switch (currentDirection){
            case NORTH:
                positionProposal = new Position(this.currentPosition.getX(), this.increment(this.currentPosition.getY()));
                break;
            case SOUTH:
                positionProposal = new Position(this.currentPosition.getX(), this.decrement(this.currentPosition.getY()));
                break;
            case EAST:
                positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case WEST:
                positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            default:
                positionProposal = currentPosition;
        }
        if(this.marsMap.isPositionAvailable(positionProposal)){
            this.currentPosition = positionProposal;
            return true;
        }
        return false;
    }

    private Boolean moveBackward() {
        Position positionProposal;
        switch (currentDirection){
            case NORTH:
                positionProposal = new Position(this.currentPosition.getX(), this.decrement(this.currentPosition.getY()));
                break;
            case SOUTH:
                positionProposal = new Position(this.currentPosition.getX(), this.increment(this.currentPosition.getY()));
                break;
            case EAST:
                positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case WEST:
                positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            default:
                positionProposal = currentPosition;
        }
        if(this.marsMap.isPositionAvailable(positionProposal)){
            this.currentPosition = positionProposal;
            return true;
        }
        return false;
    }

    private Boolean moveLeft() {
        Position positionProposal;
        switch (currentDirection){
            case NORTH:
                positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case SOUTH:
                positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case EAST:
                positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case WEST:
                positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            default:
                positionProposal = currentPosition;
        }
        if(this.marsMap.isPositionAvailable(positionProposal)){
            this.currentPosition = positionProposal;
            return true;
        }
        return false;
    }

    private Boolean moveRight() {
        Position positionProposal;
        switch (currentDirection){
            case NORTH:
                positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case SOUTH:
                positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case EAST:
                positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            case WEST:
                positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                break;
            default:
                positionProposal = currentPosition;
        }
        if(this.marsMap.isPositionAvailable(positionProposal)){
            this.currentPosition = positionProposal;
            return true;
        }
        return false;
    }

    private Integer decrement(Integer point) {
        Integer newPointCandidate;
        newPointCandidate = point - 1;
        if (newPointCandidate < 0) {
            newPointCandidate = Mars.SIZE;
        }
        return newPointCandidate;
    }

    private Integer increment(Integer point) {
        Integer newPointCandidate;
        newPointCandidate = point + 1;
        if (newPointCandidate > Mars.SIZE) {
            newPointCandidate = 0;
        }
        return newPointCandidate;
    }
}
