/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

public enum ViewType {
    Native,
    NonNative;
    

    private ViewType() {
    }

    public static ViewType parseInt(int n2) {
        if (n2 - 1 == Native.ordinal()) {
            return Native;
        }
        if (n2 - 1 != NonNative.ordinal()) throw new IllegalStateException("Internal Error: Unknown view type");
        return NonNative;
    }
}

