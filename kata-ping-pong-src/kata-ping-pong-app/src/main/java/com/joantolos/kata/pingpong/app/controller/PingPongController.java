package com.joantolos.kata.pingpong.app.controller;

import com.joantolos.kata.pingpong.domain.PingPongService;
import com.joantolos.kata.pingpong.domain.utils.HttpBuilder;
import com.joantolos.kata.pingpong.domain.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {

    private final Logger log = LoggerFactory.getLogger(PingPongController.class);

    private final PingPongService service;
    private final HttpBuilder responseBuilder;

    @Autowired
    public PingPongController(PingPongService service, HttpBuilder responseBuilder){
        this.service = service;
        this.responseBuilder = responseBuilder;
    }

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity ping() {
        log.info("\t *** /ping endpoint called");

        return responseBuilder.build(JsonUtils.toJson(service.ping()));
    }

    @RequestMapping(value = "/pong", method = RequestMethod.GET)
    public ResponseEntity pong() {
        log.info("\t *** /pong endpoint called");

        return responseBuilder.build(JsonUtils.toJson(service.pong()));
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public ResponseEntity play() {
        log.info("\t *** /play endpoint called");

        return responseBuilder.build(JsonUtils.toJson(service.play()));
    }
}
