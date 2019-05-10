package com.joantolos.kata.pingpong.app.controller;

import com.joantolos.kata.pingpong.domain.utils.JsonUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Objects;

@TestPropertySource(
        properties = {
                "eureka.client.enabled=false",
                "eureka.client.register-with-eureka=false",
                "eureka.client.fetch-registry=false",
                "server.port=7111"
        }
)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PingPongControllerTest {

    @Autowired private PingPongController pingPongController;

    @Test
    public void shouldPing() {
        String pingResponseJson = Objects.requireNonNull(this.pingPongController.ping().getBody()).toString();
        Map<String, String> pingResponse = (Map<String, String>) JsonUtils.toClass(pingResponseJson, Map.class);
        Assert.assertEquals("Ping!", pingResponse.get("move"));
    }

}