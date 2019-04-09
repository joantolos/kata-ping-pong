package com.joantolos.kata.pingpong.domain.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static String toJson(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    public static String toPrettyJson(Object o) {
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    public static Object toClass(String json, Class c) {
        try {
            return new ObjectMapper().readValue(json, c);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public static <T> List<T> toClassList(String json) {
        try {
            return new ObjectMapper().readValue(json, new TypeReference<List<T>>(){});
        } catch (IOException e) {
            return null;
        }
    }
}
