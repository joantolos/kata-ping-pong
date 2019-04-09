package com.joantolos.kata.pingpong.domain;

import com.joantolos.kata.pingpong.domain.entity.Movement;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PingPongService {

    public Movement ping() {
        return new Movement("Ping!");
    }

    public Movement pong() {
        return new Movement("Pong!");
    }

    public Movement play() {
        if(new Random().nextBoolean()) {
            return this.ping();
        }
        return this.pong();
    }
}
