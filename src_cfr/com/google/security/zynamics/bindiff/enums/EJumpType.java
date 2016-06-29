/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EJumpType$1;

public enum EJumpType {
    JUMP_TRUE,
    JUMP_FALSE,
    UNCONDITIONAL,
    SWITCH;
    

    private EJumpType() {
    }

    public static final int getOrdinal(EJumpType eJumpType) {
        switch (EJumpType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[eJumpType.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
        }
        throw new IllegalArgumentException("Unknown jump type.");
    }

    public static EJumpType getType(int n2) {
        switch (n2) {
            case 0: {
                return JUMP_TRUE;
            }
            case 1: {
                return JUMP_FALSE;
            }
            case 2: {
                return UNCONDITIONAL;
            }
            case 3: {
                return SWITCH;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown jump type %d.", n2));
    }
}

