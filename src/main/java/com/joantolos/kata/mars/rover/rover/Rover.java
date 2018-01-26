package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.domain.Mars;
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

    protected Boolean moveForward(){
        Position positionProposal;
        switch (currentDirection){
            case NORTH:
                positionProposal = new Position(this.currentPosition.getX(), incrementY());
                break;
            case SOUTH:
                positionProposal = new Position(this.currentPosition.getX(), decrementY());
                break;
            case EAST:
                positionProposal = new Position(incrementX(), this.currentPosition.getY());
                break;
            case WEST:
                positionProposal = new Position(decrementX(), this.currentPosition.getY());
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

    protected Boolean moveBackward() {
        Position positionProposal;
        switch (currentDirection){
            case NORTH:
                positionProposal = new Position(this.currentPosition.getX(), decrementY());
                break;
            case SOUTH:
                positionProposal = new Position(this.currentPosition.getX(), incrementY());
                break;
            case EAST:
                positionProposal = new Position(decrementX(), this.currentPosition.getY());
                break;
            case WEST:
                positionProposal = new Position(incrementX(), this.currentPosition.getY());
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

    protected Boolean moveLeft() {
        return true;
    }

    protected Boolean moveRight() {
        return true;
    }

    private Integer incrementY() {
        Integer newYCandidate = this.currentPosition.getY() + 1;
        if(newYCandidate > Mars.SIZE){
            newYCandidate = 0;
        }
        return newYCandidate;
    }

    private Integer incrementX() {
        Integer newXCandidate = this.currentPosition.getX() + 1;
        if(newXCandidate > Mars.SIZE){
            newXCandidate = 0;
        }
        return newXCandidate;
    }

    private Integer decrementY() {
        Integer newYCandidate = this.currentPosition.getY() - 1;
        if(newYCandidate < 0){
            newYCandidate = Mars.SIZE;
        }
        return newYCandidate;
    }

    private Integer decrementX() {
        Integer newXCandidate = this.currentPosition.getX() - 1;
        if(newXCandidate < 0){
            newXCandidate = Mars.SIZE;
        }
        return newXCandidate;
    }
}
