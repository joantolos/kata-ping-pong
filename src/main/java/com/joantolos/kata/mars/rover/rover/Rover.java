package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.domain.Mars;
import com.joantolos.kata.mars.rover.domain.Position;
import com.joantolos.kata.mars.rover.ui.Console;
import com.joantolos.kata.mars.rover.utils.Compass;

public class Rover {

    private MarsMap marsMap;
    private Position currentPosition;
    private Compass currentDirection;
    private Console console;

    public Rover(Integer x, Integer y, Compass direction, Console console){
        this.currentPosition = new Position(x, y);
        this.currentDirection = direction;
        this.console = console;
        this.marsMap = new MarsMap(this.currentPosition, this.currentDirection);
    }

    public Boolean sendSequence(String commandStream) {
        for(char command: commandStream.toCharArray()){
            Boolean movementSuccess = move(Movements.byCommand(String.valueOf(command)));
            if(!movementSuccess){
                this.console.print("Obstacle found! Aborting sequence...");
                marsMap.render(currentPosition, currentDirection);
                return false;
            }
        }
        marsMap.render(currentPosition, currentDirection);
        return true;
    }

    protected Boolean move(Movements movement){
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
            case LEFT:
                switch (currentDirection){
                    case NORTH:
                        positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                        break;
                    case SOUTH:
                        positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                        break;
                    case EAST:
                        positionProposal = new Position(this.currentPosition.getX(), this.increment(this.currentPosition.getY()));
                        break;
                    case WEST:
                        positionProposal = new Position(this.currentPosition.getX(), this.decrement(this.currentPosition.getY()));
                        break;
                }
                break;
            case RIGHT:
                switch (currentDirection){
                    case NORTH:
                        positionProposal = new Position(this.increment(this.currentPosition.getX()), this.currentPosition.getY());
                        break;
                    case SOUTH:
                        positionProposal = new Position(this.decrement(this.currentPosition.getX()), this.currentPosition.getY());
                        break;
                    case EAST:
                        positionProposal = new Position(this.currentPosition.getX(), this.decrement(this.currentPosition.getY()));
                        break;
                    case WEST:
                        positionProposal = new Position(this.currentPosition.getX(), this.increment(this.currentPosition.getY()));
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
            pointCandidate = Mars.SIZE - 1;
        }
        return pointCandidate;
    }

    private Integer increment(Integer point) {
        Integer pointCandidate;
        pointCandidate = point + 1;
        if (pointCandidate >= Mars.SIZE) {
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
