package com.joantolos.kata.pingpong.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
        "com.joantolos.kata.pingpong.domain",
        "com.joantolos.kata.pingpong.app.controller"
})
@SpringBootApplication
@EnableDiscoveryClient
public class PingPongApp {

    public static void main(String[] args) {
        SpringApplication.run(PingPongApp.class, args);
    }
}
