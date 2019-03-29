package com.joantolos.kata.mars.rover.domain;

import com.joantolos.kata.mars.rover.tools.Compass;

import java.io.IOException;

public class MarsMap extends Mars {

    private String[][] coordinates;

    public MarsMap(Position position, Compass compass) throws IOException {
        super();
        this.coordinates = new String[getSize()][getSize()];
        this.render(position, compass);
    }

    public void render(Position position, Compass compass) {
        for(int x = getSize() - 1; x >= 0; x--){
            for(int y = 0; y < getSize(); y++){
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
        return super.obstacles().stream().filter(obstacle -> obstacle.equals(position)).findFirst().orElse(null)==null;
    }

    public String[][] getCoordinates() {
        return coordinates;
    }

    public String printable() {
        StringBuilder printableMap = new StringBuilder();
        for(int x = getSize() - 1; x >= 0; x--) {
            for(int y = 0; y < getSize() ; y++){
                printableMap.append(coordinates[x][y]);
            }
            printableMap.append("\n");
        }
        return printableMap.toString();
    }
}
