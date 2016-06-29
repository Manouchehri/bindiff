/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EGraphLayout$1;

public enum EGraphLayout {
    HIERARCHICAL,
    ORTHOGONAL,
    CIRCULAR;
    

    private EGraphLayout() {
    }

    public static EGraphLayout getEnum(int n2) {
        switch (n2) {
            case 0: {
                return HIERARCHICAL;
            }
            case 1: {
                return ORTHOGONAL;
            }
            case 2: {
                return CIRCULAR;
            }
        }
        throw new IllegalArgumentException("Unknown layout style.");
    }

    public static int getOrdinal(EGraphLayout eGraphLayout) {
        switch (EGraphLayout$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[eGraphLayout.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
        }
        throw new IllegalArgumentException("Unknown layout style.");
    }
}

