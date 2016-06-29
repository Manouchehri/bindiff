/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.common.config;

import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;

public final class ConfigHelper {
    private ConfigHelper() {
    }

    public static String getConfigurationDirectory(String string, String string2) {
        String string3 = ConfigHelper.getZynamicsDirectory(string);
        String string4 = String.valueOf(File.separator);
        return new StringBuilder(0 + String.valueOf(string3).length() + String.valueOf(string2).length() + String.valueOf(string4).length()).append(string3).append(string2).append(string4).toString();
    }

    public static String getZynamicsDirectory(String string) {
        String string2;
        String string3 = SystemHelpers.getApplicationDataDirectory();
        String string4 = String.valueOf(File.separator);
        if (SystemHelpers.isRunningWindows()) {
            string2 = string;
        } else {
            String string5 = String.valueOf(string.toLowerCase());
            string2 = string5.length() != 0 ? ".".concat(string5) : new String(".");
        }
        String string6 = string2;
        String string7 = String.valueOf(File.separator);
        return new StringBuilder(0 + String.valueOf(string3).length() + String.valueOf(string4).length() + String.valueOf(string6).length() + String.valueOf(string7).length()).append(string3).append(string4).append(string6).append(string7).toString();
    }

    public static final String getMachineConfigFileName(String string, String string2) {
        String string3;
        String string4 = String.valueOf(SystemHelpers.getAllUsersApplicationDataDirectory(string));
        String string5 = String.valueOf(string2);
        if (string5.length() != 0) {
            string3 = string4.concat(string5);
            return string3;
        }
        string3 = new String(string4);
        return string3;
    }

    public static String getConfigFileName(String string, String string2, String string3) {
        String string4;
        String string5 = String.valueOf(ConfigHelper.getConfigurationDirectory(string, string2));
        String string6 = String.valueOf(string3);
        if (string6.length() != 0) {
            string4 = string5.concat(string6);
            return string4;
        }
        string4 = new String(string5);
        return string4;
    }
}

