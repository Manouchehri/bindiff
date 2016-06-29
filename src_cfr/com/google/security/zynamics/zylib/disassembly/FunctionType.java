/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.FunctionType$1;

public enum FunctionType {
    NORMAL,
    LIBRARY,
    IMPORT,
    THUNK,
    ADJUSTOR_THUNK,
    INVALID,
    UNKNOWN;
    

    private FunctionType() {
    }

    public static FunctionType parseInt(int n2) {
        switch (n2) {
            case 1: {
                return NORMAL;
            }
            case 2: {
                return LIBRARY;
            }
            case 3: {
                return IMPORT;
            }
            case 4: {
                return THUNK;
            }
            case 5: {
                return ADJUSTOR_THUNK;
            }
            case 6: {
                return INVALID;
            }
            case 7: {
                return UNKNOWN;
            }
        }
        throw new IllegalArgumentException(new StringBuilder(49).append("Internal Error: Invalid function type ").append(n2).toString());
    }

    public String toString() {
        switch (FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[this.ordinal()]) {
            case 1: {
                return "Normal";
            }
            case 2: {
                return "Library";
            }
            case 3: {
                return "Imported";
            }
            case 4: {
                return "Thunk";
            }
            case 5: {
                return "Adjustor Thunk";
            }
            case 6: {
                return "Invalid";
            }
            case 7: {
                return "Unknown";
            }
        }
        throw new IllegalArgumentException("Internal Error: Invalid function type");
    }
}

