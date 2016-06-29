/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean startsWithIgnoreCase(String string, String string2) {
        if (string.length() >= string2.length()) return string.regionMatches(true, 0, string2, 0, string2.length());
        return false;
    }

    public static boolean endsWithIgnoreCase(String string, String string2) {
        if (string.length() >= string2.length()) return string.regionMatches(true, string.length() - string2.length(), string2, 0, string2.length());
        return false;
    }

    public static String getLineSeparator() {
        try {
            return System.getProperty("line.separator", "\n");
        }
        catch (Exception var0) {
            return "\n";
        }
    }
}

