/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.renderers;

import com.google.security.zynamics.bindiff.enums.EFunctionType;

class FunctionTypeCellRenderer$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType = new int[EFunctionType.values().length];
        try {
            FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[EFunctionType.NORMAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[EFunctionType.LIBRARY.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[EFunctionType.THUNK.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[EFunctionType.IMPORTED.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            FunctionTypeCellRenderer$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EFunctionType[EFunctionType.UNKNOWN.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
    }
}

