/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.ECallType;

class ECallType$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType = new int[ECallType.values().length];
        try {
            ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[ECallType.NORMAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[ECallType.LIBRARY.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[ECallType.THUNK.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[ECallType.IMPORTED.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[ECallType.UNKNOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
        try {
            ECallType$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$ECallType[ECallType.MIXED.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError var0_5) {
            // empty catch block
        }
    }
}

