/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.enums;

import com.google.security.zynamics.bindiff.enums.EGraphLayout;

class EGraphLayout$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout = new int[EGraphLayout.values().length];
        try {
            EGraphLayout$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.HIERARCHICAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            EGraphLayout$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.ORTHOGONAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            EGraphLayout$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[EGraphLayout.CIRCULAR.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

