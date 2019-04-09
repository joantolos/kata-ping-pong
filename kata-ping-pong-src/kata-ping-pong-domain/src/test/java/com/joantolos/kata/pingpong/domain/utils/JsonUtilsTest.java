package com.joantolos.kata.pingpong.domain.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JsonUtilsTest {

    private SimpleDateFormat simpleDateFormat;
    private String simpleDateFormatJson;

    @Before
    public void setUp() throws IOException {
        this.simpleDateFormat = new SimpleDateFormat("dd/M/yyyy");
        this.simpleDateFormatJson = StringUtils.toString(ClassLoader.getSystemResourceAsStream("simpleDateFormat.json"));
    }

    @Test
    public void objectToJsonTest() {
        String json = JsonUtils.toJson(simpleDateFormat);
        Assert.assertNotNull(json);
    }

    @Test
    public void jsonToObjectTest() {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)JsonUtils.toClass(simpleDateFormatJson, SimpleDateFormat.class);
        Assert.assertNotNull(simpleDateFormat);
    }

    @Test
    public void toClassListTest() {
        List<SimpleDateFormat> simpleDateFormats = new ArrayList<>();
        simpleDateFormats.add(this.simpleDateFormat);

        String simpleDateFormatsJson = JsonUtils.toJson(simpleDateFormats);
        List<SimpleDateFormat> simpleDateFormatList = JsonUtils.toClassList(simpleDateFormatsJson);

        Assert.assertNotNull(simpleDateFormatList);
        Assert.assertTrue(simpleDateFormatList.size() > 0);
        Assert.assertNotNull(simpleDateFormatList.get(0));
    }

    @Test
    public void objectToPrettyJsonTest() {
        String json = JsonUtils.toPrettyJson(simpleDateFormat);
        Assert.assertNotNull(json);
    }

    @Test
    public void shouldReturnErrorWhenMalformedJSON() {
        Assert.assertTrue(JsonUtils.toClass("{\"name\":\"Some ", SimpleDateFormat.class).toString().startsWith("Unrecognized field \"name\""));
    }

    @Test
    public void shouldReturnErrorWhenMalformedListJSON() {
        Assert.assertNull(JsonUtils.toClassList(simpleDateFormatJson));
    }

    @Test
    public void shouldReturnErrorWhenMalformedObjectJSON() {
        Assert.assertTrue(JsonUtils.toJson(new ClassThatJacksonCannotSerialize()).startsWith("No serializer found for class"));
    }

    @Test
    public void shouldReturnErrorWhenMalformedObjectPrettyJSON() {
        Assert.assertTrue(JsonUtils.toPrettyJson(new ClassThatJacksonCannotSerialize()).startsWith("No serializer found for class"));
    }

    private static class ClassThatJacksonCannotSerialize {
        private final ClassThatJacksonCannotSerialize self = this;

        @Override
        public String toString() {
            return self.getClass().getName();
        }
    }

}
