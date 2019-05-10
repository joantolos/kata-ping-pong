package com.joantolos.kata.pingpong.domain.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpBuilderTest {

    private HttpBuilder httpBuilder;

    @Before
    public void setUp() {
        this.httpBuilder = new HttpBuilder();
    }

    @Test
    public void shouldBuildServerErrorResponse() {
        ResponseEntity errorResponse = this.httpBuilder.build(new RuntimeException("My Error"));
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, errorResponse.getStatusCode());
    }
}
