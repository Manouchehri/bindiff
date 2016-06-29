/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

public enum EOrthogonalLayoutStyle {
    NORMAL,
    TREE;
    

    private EOrthogonalLayoutStyle() {
    }

    public static EOrthogonalLayoutStyle getEnum(int n2) {
        EOrthogonalLayoutStyle eOrthogonalLayoutStyle;
        if (n2 == 0) {
            eOrthogonalLayoutStyle = NORMAL;
            return eOrthogonalLayoutStyle;
        }
        eOrthogonalLayoutStyle = TREE;
        return eOrthogonalLayoutStyle;
    }

    public static int getOrdinal(EOrthogonalLayoutStyle eOrthogonalLayoutStyle) {
        if (eOrthogonalLayoutStyle != NORMAL) return 1;
        return 0;
    }
}

