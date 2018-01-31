package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.domain.Mars;
import com.joantolos.kata.mars.rover.domain.Position;
import com.joantolos.kata.mars.rover.utils.Compass;

import java.util.stream.IntStream;

public class MarsMap {

    private String[][] coordinates;

    public MarsMap(Position position, Compass compass){
        this.coordinates = new String[Mars.SIZE][Mars.SIZE];
        this.render(position, compass);
    }

    public void render(Position position, Compass compass) {
        for(int x = Mars.SIZE - 1; x >= 0; x--){
            for(int y = 0; y < Mars.SIZE; y++){
                if(x == position.getX() && y == position.getY()){
                    coordinates[y][x] = "[ " + compass.getSymbol() + " ]";
                } else {
                    if(isPositionAvailable(new Position(x, y))) {
                        coordinates[y][x] = "[   ]";
                    } else {
                        coordinates[y][x] = "[ " + Mars.OBSTACLE + " ]";
                    }
                }
            }
        }
    }

    public Boolean isPositionAvailable(Position position){
        return Mars.obstacles().stream().filter(obstacle -> obstacle.equals(position)).findFirst().orElse(null)==null;
    }

    public String[][] getCoordinates() {
        return coordinates;
    }
}
