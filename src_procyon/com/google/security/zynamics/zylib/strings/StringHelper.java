package com.google.security.zynamics.zylib.strings;

public class StringHelper
{
    public static int count(final String s, final char c) {
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                ++n;
            }
        }
        return n;
    }
    
    public static String replaceAll(final String s, final String s2, final String s3) {
        int i;
        String string;
        String value;
        String value2;
        for (i = s.indexOf(s2), string = s; i != -1; i = string.indexOf(s2)) {
            value = String.valueOf(string.substring(0, i));
            value2 = String.valueOf(string.substring(i + s2.length()));
            string = new StringBuilder(0 + String.valueOf(value).length() + String.valueOf(s3).length() + String.valueOf(value2).length()).append(value).append(s3).append(value2).toString();
        }
        return string;
    }
}
