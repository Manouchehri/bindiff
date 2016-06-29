package com.google.security.zynamics.bindiff.utils;

public class FlagUtils
{
    public static boolean parseFlag(final byte b, final byte b2) {
        if (b2 < 0 || b2 > 7) {
            throw new IllegalArgumentException("Flag has only 8 bits.");
        }
        return 0x0 != (b >>> b2 & 0x1);
    }
    
    public static boolean parseFlag(final int n, final byte b) {
        if (b < 0 || b > 31) {
            throw new IllegalArgumentException("Flag has only 32 bits.");
        }
        return 0x0 != (n >>> b & 0x1);
    }
    
    public static byte setFlag(final byte b, final byte b2) {
        if (b2 < 0 || b2 > 7) {
            throw new IllegalArgumentException("Flag has only 8 bits.");
        }
        return (byte)(b | 1 << b2);
    }
    
    public static int setFlag(final int n, final byte b) {
        if (b < 0 || b > 31) {
            throw new IllegalArgumentException("Flag has only 32 bits.");
        }
        return n | 1 << b;
    }
}
