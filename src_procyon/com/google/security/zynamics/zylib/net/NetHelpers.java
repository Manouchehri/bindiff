package com.google.security.zynamics.zylib.net;

public class NetHelpers
{
    private static final int MAX_PORT = 65535;
    
    public static boolean isValidPort(final int n) {
        return n >= 0 && n <= 65535;
    }
    
    public static boolean isValidPort(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
}
