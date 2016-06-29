/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.PrintStream;

public class OSInfo {
    public static void main(String[] arrstring) {
        if (arrstring.length >= 1) {
            if ("--os".equals(arrstring[0])) {
                System.out.print(OSInfo.getOSName());
                return;
            }
            if ("--arch".equals(arrstring[0])) {
                System.out.print(OSInfo.getArchName());
                return;
            }
        }
        System.out.print(OSInfo.getNativeLibFolderPathForCurrentOS());
    }

    public static String getNativeLibFolderPathForCurrentOS() {
        return OSInfo.getOSName() + "/" + OSInfo.getArchName();
    }

    public static String getOSName() {
        return OSInfo.translateOSNameToFolderName(System.getProperty("os.name"));
    }

    public static String getArchName() {
        return OSInfo.translateArchNameToFolderName(System.getProperty("os.arch"));
    }

    public static String translateOSNameToFolderName(String string) {
        if (string.contains("Windows")) {
            return "Windows";
        }
        if (string.contains("Mac")) {
            return "Mac";
        }
        if (!string.contains("Linux")) return string.replaceAll("\\W", "");
        return "Linux";
    }

    public static String translateArchNameToFolderName(String string) {
        return string.replaceAll("\\W", "");
    }
}

