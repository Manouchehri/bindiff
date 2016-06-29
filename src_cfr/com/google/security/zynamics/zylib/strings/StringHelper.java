/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.strings;

public class StringHelper {
    public static int count(String string, char c2) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < string.length()) {
            if (string.charAt(n3) == c2) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    public static String replaceAll(String string, String string2, String string3) {
        int n2 = string.indexOf(string2);
        String string4 = string;
        while (n2 != -1) {
            String string5 = String.valueOf(string4.substring(0, n2));
            String string6 = String.valueOf(string4.substring(n2 + string2.length()));
            string4 = new StringBuilder(0 + String.valueOf(string5).length() + String.valueOf(string3).length() + String.valueOf(string6).length()).append(string5).append(string3).append(string6).toString();
            n2 = string4.indexOf(string2);
        }
        return string4;
    }
}

