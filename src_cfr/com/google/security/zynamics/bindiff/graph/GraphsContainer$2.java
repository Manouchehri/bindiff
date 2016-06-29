/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.enums.EDiffViewMode;

class GraphsContainer$2 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode = new int[EDiffViewMode.values().length];
        try {
            GraphsContainer$2.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.NORMAL_VIEW.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            GraphsContainer$2.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.COMBINED_VIEW.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            GraphsContainer$2.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[EDiffViewMode.TEXT_VIEW.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

