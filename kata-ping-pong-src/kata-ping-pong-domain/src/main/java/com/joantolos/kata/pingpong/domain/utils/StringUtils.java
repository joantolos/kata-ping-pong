package com.joantolos.kata.pingpong.domain.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StringUtils {

    public static String toString(Object o) throws IOException {
        if (o instanceof String) {
            return (String) o;
        }else if (o instanceof InputStream) {
            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)o));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
        if (o == null) return "";
        return new ObjectMapper().writeValueAsString(o);
    }

    public static InputStream toInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] toByteArray(final String message) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(message.getBytes(StandardCharsets.UTF_8));
        return out.toByteArray();
    }

    public static String removeSurroundingQuotes(String string) {
        string = string.trim();
        string = org.apache.commons.lang.StringUtils.stripEnd(string, "\"");
        return org.apache.commons.lang.StringUtils.stripStart(string, "\"");
    }

    public static String stringFromSubStringLastAppearance(String string, String subString) {
        if(string == null || string.isEmpty() || subString == null || subString.isEmpty()) {
            return "";
        } else {
            int lastIndexOfSubString = string.lastIndexOf(subString);
            if (lastIndexOfSubString < 0) {
                return string;
            }
            return string.substring(0, lastIndexOfSubString);
        }
    }

    public static boolean isEmpty(String string){
        return org.apache.commons.lang.StringUtils.isEmpty(string);
    }

    public static String removeQuotes(String value) {
        if (isSurroundedByQuotes(value)) {
            value = value.substring(1, value.length() - 1);
        }
        return value;
    }

    private static boolean isSurroundedByQuotes(String value) {
        return value.startsWith("\"") && value.endsWith("\"");
    }

}
