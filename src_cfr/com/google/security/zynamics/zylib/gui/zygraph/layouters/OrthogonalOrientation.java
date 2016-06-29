/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum OrthogonalOrientation {
    VERTICAL,
    HORIZONTAL;
    

    private OrthogonalOrientation() {
    }

    public static OrthogonalOrientation parseInt(int n2) {
        if (n2 == VERTICAL.ordinal()) {
            return VERTICAL;
        }
        if (n2 != HORIZONTAL.ordinal()) throw new IllegalStateException("Internal Error: Unknown orientation");
        return HORIZONTAL;
    }
}

