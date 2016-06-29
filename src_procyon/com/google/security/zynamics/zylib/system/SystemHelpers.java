package com.google.security.zynamics.zylib.system;

import com.google.security.zynamics.zylib.io.*;
import java.io.*;

public final class SystemHelpers
{
    public static String getAllUsersApplicationDataDirectory() {
        String s;
        if (isRunningWindows()) {
            s = System.getenv("ProgramData");
            if (s == null) {
                final String getenv = System.getenv("APPDATA");
                final String value = String.valueOf(System.getenv("ALLUSERSPROFILE"));
                final String value2 = String.valueOf((getenv != null) ? getenv.substring(getenv.lastIndexOf(92)) : "\\Application Data");
                s = ((value2.length() != 0) ? value.concat(value2) : new String(value));
            }
        }
        else if (isRunningLinux()) {
            s = "/etc/opt";
        }
        else if (isRunningMacOSX()) {
            s = "/etc/opt";
        }
        else {
            s = System.getProperty("user.home");
        }
        return FileUtils.ensureTrailingSlash(s);
    }
    
    public static String getAllUsersApplicationDataDirectory(final String s) {
        final String allUsersApplicationDataDirectory = getAllUsersApplicationDataDirectory();
        final String value = String.valueOf(File.separator);
        final String value2 = String.valueOf(File.separator);
        return new StringBuilder(8 + String.valueOf(allUsersApplicationDataDirectory).length() + String.valueOf(value).length() + String.valueOf(s).length() + String.valueOf(value2).length()).append(allUsersApplicationDataDirectory).append("zynamics").append(value).append(s).append(value2).toString();
    }
    
    public static String getApplicationDataDirectory() {
        return FileUtils.ensureTrailingSlash(isRunningWindows() ? System.getenv("APPDATA") : System.getProperty("user.home"));
    }
    
    public static String getApplicationDataDirectory(final String s) {
        final String applicationDataDirectory = getApplicationDataDirectory();
        final String s2 = isRunningWindows() ? "" : ".";
        final String value = String.valueOf(File.separator);
        final String value2 = String.valueOf(File.separator);
        return new StringBuilder(8 + String.valueOf(applicationDataDirectory).length() + String.valueOf(s2).length() + String.valueOf(value).length() + String.valueOf(s).length() + String.valueOf(value2).length()).append(applicationDataDirectory).append(s2).append("zynamics").append(value).append(s).append(value2).toString();
    }
    
    public static String getTempDirectory() {
        return FileUtils.ensureTrailingSlash(System.getProperty("java.io.tmpdir"));
    }
    
    public static String getTempDirectory(final String s) {
        final String tempDirectory = getTempDirectory();
        final String value = String.valueOf(File.separator);
        final String value2 = String.valueOf(File.separator);
        return new StringBuilder(8 + String.valueOf(tempDirectory).length() + String.valueOf(value).length() + String.valueOf(s).length() + String.valueOf(value2).length()).append(tempDirectory).append("zynamics").append(value).append(s).append(value2).toString();
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
        if (isRunningWindows()) {
            return "AMD64".equals(System.getenv("PROCESSOR_ARCHITECTURE")) || "AMD64".equals(System.getenv("PROCESSOR_ARCHITEW6432"));
        }
        throw new RuntimeException("Not implemented");
    }
}
