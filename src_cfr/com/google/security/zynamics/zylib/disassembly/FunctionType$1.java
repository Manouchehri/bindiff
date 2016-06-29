/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.FunctionType;

class FunctionType$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType;

    static {
        $SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType = new int[FunctionType.values().length];
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.NORMAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.LIBRARY.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.IMPORT.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.THUNK.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.ADJUSTOR_THUNK.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.INVALID.ordinal()] = 6;
        }
        catch (NoSuchFieldError var0_5) {
            // empty catch block
        }
        try {
            FunctionType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$FunctionType[FunctionType.UNKNOWN.ordinal()] = 7;
            return;
        }
        catch (NoSuchFieldError var0_6) {
            // empty catch block
        }
    }
}

