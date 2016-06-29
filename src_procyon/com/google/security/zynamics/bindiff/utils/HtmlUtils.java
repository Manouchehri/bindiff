package com.google.security.zynamics.bindiff.utils;

import java.awt.*;

public class HtmlUtils
{
    public static String escapeHtml(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int n = (s == null) ? 0 : s.length(), i = 0; i < n; ++i) {
            final char char1 = s.charAt(i);
            if (Character.isLetterOrDigit(char1)) {
                sb.append(char1);
            }
            else {
                sb.append(new StringBuilder(14).append("&#").append((int)char1).append(";").toString());
            }
        }
        return sb.toString();
    }
    
    public static String getHexColorValue(final Color color) {
        return Integer.toHexString(color.getRGB()).substring(2);
    }
    
    public static String insertOptionalWordBreaks(final String s, final int n, final int n2, final boolean b) {
        String string = "";
        final String[] split = s.split(" ");
        int n3 = 1;
        for (final String s2 : split) {
            String concat = "";
            String s4;
            if (s2.length() > n) {
                int j;
                for (j = 0; j < s2.length() - s2.length() % n2 - 1; j += n2) {
                    String s3;
                    if (b) {
                        final String value = String.valueOf(concat);
                        final String value2 = String.valueOf(escapeHtml(s2.substring(j, j + n2)));
                        s3 = ((value2.length() != 0) ? value.concat(value2) : new String(value));
                    }
                    else {
                        final String value3 = String.valueOf(concat);
                        final String value4 = String.valueOf(s2.substring(j, j + n2));
                        s3 = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
                    }
                    concat = String.valueOf(s3).concat("<span style=\"display:block;width:1px;float:left;\"> </span>");
                }
                final String value5 = String.valueOf(concat);
                final String value6 = String.valueOf(s2.substring(j));
                s4 = ((value6.length() != 0) ? value5.concat(value6) : new String(value5));
            }
            else {
                s4 = (b ? escapeHtml(s2) : s2);
            }
            final String value7 = String.valueOf(string);
            final String s5 = (n3 != 0) ? "" : (b ? escapeHtml(" ") : " ");
            final String s6 = s4;
            string = new StringBuilder(0 + String.valueOf(value7).length() + String.valueOf(s5).length() + String.valueOf(s6).length()).append(value7).append(s5).append(s6).toString();
            n3 = 0;
        }
        return string;
    }
}
