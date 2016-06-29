/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph;

public enum EdgeHidingMode {
    HIDE_NEVER,
    HIDE_ALWAYS,
    HIDE_ON_THRESHOLD;
    

    private EdgeHidingMode() {
    }

    public static EdgeHidingMode parseInt(int n2) {
        if (n2 == HIDE_NEVER.ordinal()) {
            return HIDE_NEVER;
        }
        if (n2 == HIDE_ALWAYS.ordinal()) {
            return HIDE_ALWAYS;
        }
        if (n2 != HIDE_ON_THRESHOLD.ordinal()) throw new IllegalStateException("Error: Invalid edge hiding mode");
        return HIDE_ON_THRESHOLD;
    }
}

