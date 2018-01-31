package com.joantolos.kata.mars.rover.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Mars {

    public final static Integer SIZE = 10;
    private final static Integer MAX_OBSTACLE_NUM = 4;
    private static List<Position> obstacles = new ArrayList<>();

    public static List<Position> obstacles(){
        if(obstacles.size() == 0) {
            repeat(MAX_OBSTACLE_NUM, () -> obstacles.add(new Position(randomPoint(), randomPoint())));
        }
        return obstacles;
    }

    private static void repeat(int count, Runnable action) {
        IntStream.range(0, count).forEach(i -> action.run());
    }

    private static int randomPoint() {
        return new Random().nextInt(SIZE - 1 + 1) + 1;
    }

}
