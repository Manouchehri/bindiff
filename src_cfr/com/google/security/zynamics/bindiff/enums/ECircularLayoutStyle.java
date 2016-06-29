/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle$1;

public enum ECircularLayoutStyle {
    COMPACT,
    ISOLATED,
    SINGLE_CYCLE;
    

    private ECircularLayoutStyle() {
    }

    public static ECircularLayoutStyle getEnum(int n2) {
        switch (n2) {
            case 0: {
                return COMPACT;
            }
            case 1: {
                return ISOLATED;
            }
            case 2: {
                return SINGLE_CYCLE;
            }
        }
        throw new IllegalArgumentException("Unknown circular layout style.");
    }

    public static int getOrdinal(ECircularLayoutStyle eCircularLayoutStyle) {
        switch (ECircularLayoutStyle$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECircularLayoutStyle[eCircularLayoutStyle.ordinal()]) {
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
        throw new IllegalArgumentException("Unknown cicular layout style.");
    }
}

