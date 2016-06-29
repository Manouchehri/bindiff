/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel;

import com.google.security.zynamics.bindiff.enums.EMatchType;

class FunctionDiffViewTabPanel$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType = new int[EMatchType.values().length];
        try {
            FunctionDiffViewTabPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[EMatchType.IDENTICAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            FunctionDiffViewTabPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[EMatchType.INSTRUCTIONS_CHANGED.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            FunctionDiffViewTabPanel$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchType[EMatchType.STRUCTURAL_CHANGED.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

