package com.joantolos.kata.mars.rover.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

public class Mars {

    private Integer size;
    private Integer maxObstacle;
    public final static String OBSTACLE = "\u1040";
    private static List<Position> obstacles = new ArrayList<>();

    public Mars() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/mars.properties"));
        this.size = Integer.valueOf(prop.getProperty("size"));
        this.maxObstacle = Integer.valueOf(prop.getProperty("max.obstacles"));
    }

    public List<Position> obstacles() {
        if(obstacles.size() == 0) {
            repeat(maxObstacle, () -> obstacles.add(new Position(randomPoint(), randomPoint())));
        }
        return obstacles;
    }

    private void repeat(int count, Runnable action) {
        IntStream.range(0, count).forEach(i -> action.run());
    }

    private int randomPoint() {
        return new Random().nextInt(size - 1 + 1) + 1;
    }

    public Integer getSize() {
        return size;
    }
}
