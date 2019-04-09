package com.joantolos.kata.pingpong.domain.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Collections;

@Component
public class HttpBuilder {

    public ResponseEntity build(String data) {
        return this.build(jsonByDefault(), data);
    }

    public ResponseEntity build(MultivaluedMap<String, String> headers, String data) {
        HttpHeaders springHeaders = new HttpHeaders();
        if(headers!=null && !headers.isEmpty()) {
            for (String key : headers.keySet()) {
                springHeaders.add(key, headers.getFirst(key));
            }
        }
        return ResponseEntity.ok().headers(springHeaders).body(data);
    }

    public ResponseEntity build(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    private MultivaluedMap<String, String> jsonByDefault() {
        MultivaluedMap<String, String> multivaluedResponseHeaders = new MultivaluedHashMap<>();
        multivaluedResponseHeaders.put(HttpHeaders.CONTENT_TYPE, Collections.singletonList(MediaType.APPLICATION_JSON));
        return multivaluedResponseHeaders;
    }

}
