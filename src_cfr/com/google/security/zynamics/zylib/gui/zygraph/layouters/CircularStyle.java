/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum CircularStyle {
    COMPACT,
    ISOLATED,
    SINGLE_CIRCLE;
    

    private CircularStyle() {
    }

    public static CircularStyle parseInt(int n2) {
        if (n2 == COMPACT.ordinal()) {
            return COMPACT;
        }
        if (n2 == ISOLATED.ordinal()) {
            return ISOLATED;
        }
        if (n2 != SINGLE_CIRCLE.ordinal()) throw new IllegalStateException("Error: Invalid style");
        return SINGLE_CIRCLE;
    }
}

