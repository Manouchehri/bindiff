/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.system;

import com.google.security.zynamics.zylib.io.FileUtils;
import java.io.File;

public final class SystemHelpers {
    public static String getAllUsersApplicationDataDirectory() {
        String string;
        if (SystemHelpers.isRunningWindows()) {
            string = System.getenv("ProgramData");
            if (string != null) return FileUtils.ensureTrailingSlash(string);
            String string2 = System.getenv("APPDATA");
            String string3 = String.valueOf(System.getenv("ALLUSERSPROFILE"));
            String string4 = String.valueOf(string2 != null ? string2.substring(string2.lastIndexOf(92)) : "\\Application Data");
            string = string4.length() != 0 ? string3.concat(string4) : new String(string3);
            return FileUtils.ensureTrailingSlash(string);
        }
        if (SystemHelpers.isRunningLinux()) {
            string = "/etc/opt";
            return FileUtils.ensureTrailingSlash(string);
        }
        if (SystemHelpers.isRunningMacOSX()) {
            string = "/etc/opt";
            return FileUtils.ensureTrailingSlash(string);
        }
        string = System.getProperty("user.home");
        return FileUtils.ensureTrailingSlash(string);
    }

    public static String getAllUsersApplicationDataDirectory(String string) {
        String string2 = SystemHelpers.getAllUsersApplicationDataDirectory();
        String string3 = String.valueOf(File.separator);
        String string4 = String.valueOf(File.separator);
        return new StringBuilder(8 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string).length() + String.valueOf(string4).length()).append(string2).append("zynamics").append(string3).append(string).append(string4).toString();
    }

    public static String getApplicationDataDirectory() {
        String string;
        if (SystemHelpers.isRunningWindows()) {
            string = System.getenv("APPDATA");
            return FileUtils.ensureTrailingSlash(string);
        }
        string = System.getProperty("user.home");
        return FileUtils.ensureTrailingSlash(string);
    }

    public static String getApplicationDataDirectory(String string) {
        String string2 = SystemHelpers.getApplicationDataDirectory();
        String string3 = SystemHelpers.isRunningWindows() ? "" : ".";
        String string4 = String.valueOf(File.separator);
        String string5 = String.valueOf(File.separator);
        return new StringBuilder(8 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length() + String.valueOf(string).length() + String.valueOf(string5).length()).append(string2).append(string3).append("zynamics").append(string4).append(string).append(string5).toString();
    }

    public static String getTempDirectory() {
        return FileUtils.ensureTrailingSlash(System.getProperty("java.io.tmpdir"));
    }

    public static String getTempDirectory(String string) {
        String string2 = SystemHelpers.getTempDirectory();
        String string3 = String.valueOf(File.separator);
        String string4 = String.valueOf(File.separator);
        return new StringBuilder(8 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string).length() + String.valueOf(string4).length()).append(string2).append("zynamics").append(string3).append(string).append(string4).toString();
    }

    public static String getUserDirectory() {
        return FileUtils.ensureTrailingSlash(System.getProperty("user.home"));
    }

    public static boolean isRunningLinux() {
        return System.getProperty("os.name").startsWith("Linux");
    }

    public static boolean isRunningMacOSX() {
        return System.getProperty("os.name").startsWith("Mac");
    }

    public static boolean isRunningWindows() {
        return System.getProperty("os.name").startsWith("Windows");
    }

    public static boolean is64BitArchitecture() {
        if (!SystemHelpers.isRunningWindows()) throw new RuntimeException("Not implemented");
        if ("AMD64".equals(System.getenv("PROCESSOR_ARCHITECTURE"))) return true;
        if ("AMD64".equals(System.getenv("PROCESSOR_ARCHITEW6432"))) return true;
        return false;
    }
}

