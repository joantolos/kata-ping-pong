package com.joantolos.kata.mars.rover.domain;

import com.joantolos.kata.mars.rover.tools.Compass;
import com.joantolos.kata.mars.rover.ui.Console;

import java.io.IOException;

public class Rover {

    private MarsMap marsMap;
    private Position currentPosition;
    private Compass currentDirection;
    private Console console;

    public Rover(Integer x, Integer y, Compass direction, Console console) throws IOException {
        this.currentPosition = new Position(x, y);
        this.currentDirection = direction;
        this.console = console;
        this.marsMap = new MarsMap(this.currentPosition, this.currentDirection);
    }

    public Boolean sendSequence(String commandStream) {
        for(char command: commandStream.toCharArray()){
            Movements movement = Movements.byCommand(String.valueOf(command).toLowerCase());
            if(movement != null) {
                Boolean movementSuccess = move(movement);
                marsMap.render(currentPosition, currentDirection);
                if (!movementSuccess) {
                    this.console.print("Obstacle found! Aborting sequence...");
                    return false;
                }
            } else {
                this.console.print("Please enter a valid command... " + commandStream + " won't work.");
                return false;
            }
        }
        return true;
    }

    public Boolean move(Movements movement){
        Position positionProposal = this.currentPosition;
        switch (movement) {
            case FORWARD:
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
                }
                break;
            case BACKWARD:
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
                }
                break;
            case NORTH:
                this.currentDirection = Compass.NORTH;
                return true;
            case SOUTH:
                this.currentDirection = Compass.SOUTH;
                return true;
            case EAST:
                this.currentDirection = Compass.EAST;
                return true;
            case WEST:
                this.currentDirection = Compass.WEST;
                return true;
        }
        if(this.marsMap.isPositionAvailable(positionProposal)){
            this.currentPosition = positionProposal;
            return true;
        }
        return false;
    }

    private Integer decrement(Integer point) {
        Integer pointCandidate;
        pointCandidate = point - 1;
        if (pointCandidate <= 0) {
            pointCandidate = marsMap.getSize() - 1;
        }
        return pointCandidate;
    }

    private Integer increment(Integer point) {
        Integer pointCandidate;
        pointCandidate = point + 1;
        if (pointCandidate >= marsMap.getSize()) {
            pointCandidate = 0;
        }
        return pointCandidate;
    }

    public Position getPosition() {
        return this.currentPosition;
    }

    public Compass getDirection() {
        return currentDirection;
    }

    public MarsMap getMarsMap() {
        return marsMap;
    }
}
