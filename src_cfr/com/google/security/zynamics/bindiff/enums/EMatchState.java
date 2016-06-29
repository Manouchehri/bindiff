/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EMatchState$1;

public enum EMatchState {
    MATCHED,
    PRIMARY_UNMATCHED,
    SECONDRAY_UNMATCHED;
    

    private EMatchState() {
    }

    public static EMatchState getMatchState(int n2) {
        switch (n2) {
            case 0: {
                return MATCHED;
            }
            case 1: {
                return PRIMARY_UNMATCHED;
            }
            case 2: {
                return SECONDRAY_UNMATCHED;
            }
        }
        throw new IllegalArgumentException("Unknown match state.");
    }

    public static int getOrdinal(EMatchState eMatchState) {
        switch (EMatchState$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[eMatchState.ordinal()]) {
            case 1: {
                return 2;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 0;
            }
        }
        throw new IllegalArgumentException("Unknown match state type.");
    }

    public String toString() {
        switch (EMatchState$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[this.ordinal()]) {
            case 3: {
                return "Matched";
            }
            case 2: {
                return "Primary Unmatched";
            }
            case 1: {
                return "Secondary Unmatched";
            }
        }
        throw new IllegalArgumentException("Unknown match state type.");
    }
}

