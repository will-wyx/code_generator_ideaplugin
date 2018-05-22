package com.wyx;

public class Utils {
    public static String toCamelCase(String text) {
        String[] arr = text.split("_");
        StringBuilder sb = new StringBuilder();
        for (String item : arr) {
            item = upperCaseFirstLetter(item);
            sb.append(item);
        }
        return String.valueOf(sb);
    }

    public static String tocamelCase(String text) {
        text = toCamelCase(text);
        char[] cs = text.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }

    private static String upperCaseFirstLetter(String text) {
        text = text.toLowerCase();
        char[] cs = text.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }
}
