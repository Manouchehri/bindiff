package com.google.security.zynamics.common.config;

import java.io.*;
import com.google.security.zynamics.zylib.system.*;

public final class ConfigHelper
{
    public static String getConfigurationDirectory(final String s, final String s2) {
        final String zynamicsDirectory = getZynamicsDirectory(s);
        final String value = String.valueOf(File.separator);
        return new StringBuilder(0 + String.valueOf(zynamicsDirectory).length() + String.valueOf(s2).length() + String.valueOf(value).length()).append(zynamicsDirectory).append(s2).append(value).toString();
    }
    
    public static String getZynamicsDirectory(final String s) {
        final String applicationDataDirectory = SystemHelpers.getApplicationDataDirectory();
        final String value = String.valueOf(File.separator);
        String s2;
        if (SystemHelpers.isRunningWindows()) {
            s2 = s;
        }
        else {
            final String s3 = ".";
            final String value2 = String.valueOf(s.toLowerCase());
            s2 = ((value2.length() != 0) ? s3.concat(value2) : new String(s3));
        }
        final String s4 = s2;
        final String value3 = String.valueOf(File.separator);
        return new StringBuilder(0 + String.valueOf(applicationDataDirectory).length() + String.valueOf(value).length() + String.valueOf(s4).length() + String.valueOf(value3).length()).append(applicationDataDirectory).append(value).append(s4).append(value3).toString();
    }
    
    public static final String getMachineConfigFileName(final String s, final String s2) {
        final String value = String.valueOf(SystemHelpers.getAllUsersApplicationDataDirectory(s));
        final String value2 = String.valueOf(s2);
        return (value2.length() != 0) ? value.concat(value2) : new String(value);
    }
    
    public static String getConfigFileName(final String s, final String s2, final String s3) {
        final String value = String.valueOf(getConfigurationDirectory(s, s2));
        final String value2 = String.valueOf(s3);
        return (value2.length() != 0) ? value.concat(value2) : new String(value);
    }
}
