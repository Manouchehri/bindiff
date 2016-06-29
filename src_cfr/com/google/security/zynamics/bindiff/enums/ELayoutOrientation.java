/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

public enum ELayoutOrientation {
    VERTICAL,
    HORIZONTAL;
    

    private ELayoutOrientation() {
    }

    public static ELayoutOrientation getEnum(int n2) {
        ELayoutOrientation eLayoutOrientation;
        if (n2 == 0) {
            eLayoutOrientation = VERTICAL;
            return eLayoutOrientation;
        }
        eLayoutOrientation = HORIZONTAL;
        return eLayoutOrientation;
    }

    public static int getOrdinal(ELayoutOrientation eLayoutOrientation) {
        if (eLayoutOrientation != VERTICAL) return 1;
        return 0;
    }
}

