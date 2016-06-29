/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import java.awt.Color;

public class HtmlUtils {
    public static String escapeHtml(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = string == null ? 0 : string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (Character.isLetterOrDigit(c2)) {
                stringBuffer.append(c2);
            } else {
                char c3 = c2;
                stringBuffer.append(new StringBuilder(14).append("&#").append((int)c3).append(";").toString());
            }
            ++n3;
        }
        return stringBuffer.toString();
    }

    public static String getHexColorValue(Color color) {
        return Integer.toHexString(color.getRGB()).substring(2);
    }

    public static String insertOptionalWordBreaks(String string, int n2, int n3, boolean bl2) {
        String string2 = "";
        String[] arrstring = string.split(" ");
        boolean bl3 = true;
        String[] arrstring2 = arrstring;
        int n4 = arrstring2.length;
        int n5 = 0;
        while (n5 < n4) {
            String string3 = arrstring2[n5];
            String string4 = "";
            if (string3.length() <= n2) {
                string4 = bl2 ? HtmlUtils.escapeHtml(string3) : string3;
            } else {
                int n6;
                for (n6 = 0; n6 < string3.length() - string3.length() % n3 - 1; n6 += n3) {
                    if (bl2) {
                        String string5 = String.valueOf(string4);
                        String string6 = String.valueOf(HtmlUtils.escapeHtml(string3.substring(n6, n6 + n3)));
                        string4 = string6.length() != 0 ? string5.concat(string6) : new String(string5);
                    } else {
                        String string7 = String.valueOf(string4);
                        String string8 = String.valueOf(string3.substring(n6, n6 + n3));
                        string4 = string8.length() != 0 ? string7.concat(string8) : new String(string7);
                    }
                    string4 = String.valueOf(string4).concat("<span style=\"display:block;width:1px;float:left;\"> </span>");
                }
                String string9 = String.valueOf(string4);
                String string10 = String.valueOf(string3.substring(n6));
                string4 = string10.length() != 0 ? string9.concat(string10) : new String(string9);
            }
            String string11 = String.valueOf(string2);
            String string12 = bl3 ? "" : (bl2 ? HtmlUtils.escapeHtml(" ") : " ");
            String string13 = string4;
            string2 = new StringBuilder(0 + String.valueOf(string11).length() + String.valueOf(string12).length() + String.valueOf(string13).length()).append(string11).append(string12).append(string13).toString();
            bl3 = false;
            ++n5;
        }
        return string2;
    }
}

