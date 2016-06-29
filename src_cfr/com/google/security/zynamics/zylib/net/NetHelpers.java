/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.net;

public class NetHelpers {
    private static final int MAX_PORT = 65535;

    public static boolean isValidPort(int n2) {
        if (n2 < 0) return false;
        if (n2 > 65535) return false;
        return true;
    }

    public static boolean isValidPort(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException var1_1) {
            return false;
        }
    }
}

