/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum HierarchicOrientation {
    VERTICAL,
    HORIZONTAL;
    

    private HierarchicOrientation() {
    }

    public static HierarchicOrientation parseInt(int n2) {
        if (n2 == VERTICAL.ordinal()) {
            return VERTICAL;
        }
        if (n2 != HORIZONTAL.ordinal()) throw new IllegalStateException("Internal Error: Invalid orientation value");
        return HORIZONTAL;
    }
}

