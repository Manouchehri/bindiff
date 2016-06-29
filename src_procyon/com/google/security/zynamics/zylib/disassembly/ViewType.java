package com.google.security.zynamics.zylib.disassembly;

public enum ViewType
{
    Native("Native", 0), 
    NonNative("NonNative", 1);
    
    private ViewType(final String s, final int n) {
    }
    
    public static ViewType parseInt(final int n) {
        if (n - 1 == ViewType.Native.ordinal()) {
            return ViewType.Native;
        }
        if (n - 1 == ViewType.NonNative.ordinal()) {
            return ViewType.NonNative;
        }
        throw new IllegalStateException("Internal Error: Unknown view type");
    }
}
