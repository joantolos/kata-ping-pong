package com.joantolos.kata.mars.rover.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mars {

    public final static Integer SIZE = 9;
    private static List<Position> obstacles = new ArrayList<>();

    public static List<Position> obstacles(){
        if(obstacles.size() == 0) {
            obstacles.add(randomPosition());
            obstacles.add(randomPosition());
            obstacles.add(randomPosition());
            obstacles.add(randomPosition());
        }
        return obstacles;
    }

    private static Position randomPosition() {
        return new Position(randomMapPoint(), randomMapPoint());
    }

    private static Integer randomMapPoint() {
        return new Random().nextInt(SIZE - 1 + 1) + 1;
    }

}
