/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

public enum ECommentPlacement {
    ABOVE_LINE,
    BEHIND_LINE;
    

    private ECommentPlacement() {
    }

    public static int getOrdinal(ECommentPlacement eCommentPlacement) {
        if (eCommentPlacement != ABOVE_LINE) return 1;
        return 0;
    }

    public static ECommentPlacement valueOf(int n2) {
        if (n2 == 0) {
            return ABOVE_LINE;
        }
        if (n2 != 1) throw new IllegalStateException("Error: Unknown ordinal value.");
        return BEHIND_LINE;
    }
}

