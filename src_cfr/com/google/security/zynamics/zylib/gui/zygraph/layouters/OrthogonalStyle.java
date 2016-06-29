/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum OrthogonalStyle {
    NORMAL,
    TREE;
    

    private OrthogonalStyle() {
    }

    public static OrthogonalStyle parseInt(int n2) {
        if (n2 == NORMAL.ordinal()) {
            return NORMAL;
        }
        if (n2 != TREE.ordinal()) throw new IllegalStateException(new StringBuilder(32).append("Error: Invalid style ").append(n2).toString());
        return TREE;
    }
}

