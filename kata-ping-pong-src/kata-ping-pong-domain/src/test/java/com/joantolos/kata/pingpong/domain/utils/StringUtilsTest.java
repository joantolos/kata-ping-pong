package com.joantolos.kata.pingpong.domain.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StringUtilsTest {

    @Test
    public void toInputStreamTest() throws IOException {
        String input = "Some string";
        InputStream output = StringUtils.toInputStream(input);
        Assert.assertEquals(input, StringUtils.toString(output));
    }

    @Test
    public void objectToStringTest() throws IOException {
        Assert.assertEquals("10", StringUtils.toString(10));
        Assert.assertEquals("10", StringUtils.toString("10"));
        InputStream jsonAsStream = this.getClass().getResourceAsStream("unCompressedJson.json");
        String jsonAsString = StringUtils.toString(jsonAsStream);
        Assert.assertNotNull(jsonAsString);
        List<String> listToString = new ArrayList<>();
        listToString.add("0");
        listToString.add("and");
        Assert.assertEquals("[\"0\",\"and\"]", StringUtils.toString(listToString));
    }

    @Test
    public void secureSubstringTargetLastAppearanceTest(){
        String string = "Some string with.dots.in.the middle";
        String substring = StringUtils.stringFromSubStringLastAppearance(string, ".");
        Assert.assertEquals("Some string with.dots.in", substring);
        Assert.assertEquals("", StringUtils.stringFromSubStringLastAppearance(string, ""));
        Assert.assertEquals("", StringUtils.stringFromSubStringLastAppearance(string, null));
        Assert.assertEquals("", StringUtils.stringFromSubStringLastAppearance("", "."));
        Assert.assertEquals("", StringUtils.stringFromSubStringLastAppearance(null, "."));
        Assert.assertEquals("", StringUtils.stringFromSubStringLastAppearance(null, null));
        Assert.assertEquals("No value", StringUtils.stringFromSubStringLastAppearance("No value", "P"));
    }

    @Test
    public void removeQuotesTest(){
        String someStringWithQuotes = "\"I'm a string surrounded by quotes\"";
        String someStringWithQuotesAndStartingBlank = "   \"I'm a string surrounded by quotes\"";
        String someStringWithQuotesAndEndingBlank = "\"I'm a string surrounded by quotes\"   ";
        String someStringWithQuotesAndStartingEndingBlank = "   \"I'm a string surrounded by quotes\"   ";
        String someStringWithoutQuotes = "I'm a string not surrounded by quotes";

        Assert.assertEquals("I'm a string surrounded by quotes", StringUtils.removeSurroundingQuotes(someStringWithQuotes));
        Assert.assertEquals("I'm a string surrounded by quotes", StringUtils.removeSurroundingQuotes(someStringWithQuotesAndStartingBlank));
        Assert.assertEquals("I'm a string surrounded by quotes", StringUtils.removeSurroundingQuotes(someStringWithQuotesAndEndingBlank));
        Assert.assertEquals("I'm a string surrounded by quotes", StringUtils.removeSurroundingQuotes(someStringWithQuotesAndStartingEndingBlank));
        Assert.assertEquals("I'm a string not surrounded by quotes", StringUtils.removeSurroundingQuotes(someStringWithoutQuotes));
    }

    @Test
    public void shouldBeTrueWhenEmpty() {
        Assert.assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void shouldBeFalseWhenNotEmpty() {
        Assert.assertFalse(StringUtils.isEmpty("NotEmpty"));
    }

    @Test
    public void shouldConvertStringToByteArray() throws IOException {
        Assert.assertNotNull(StringUtils.toByteArray("To Byte Array"));
    }

    @Test
    public void shouldRemoveQuotes() {
        Assert.assertEquals("Text on quotes", StringUtils.removeQuotes("\"Text on quotes\""));
    }

    @Test
    public void shouldDoNothingWhenNotOnQuotes() {
        Assert.assertEquals("Text not on quotes", StringUtils.removeQuotes("Text not on quotes"));
    }

}
