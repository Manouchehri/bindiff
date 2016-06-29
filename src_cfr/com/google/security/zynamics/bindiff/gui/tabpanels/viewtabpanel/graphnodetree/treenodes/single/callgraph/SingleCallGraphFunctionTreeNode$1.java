/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.single.callgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;

class SingleCallGraphFunctionTreeNode$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState = new int[EMatchState.values().length];
        try {
            SingleCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.MATCHED.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            SingleCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.PRIMARY_UNMATCHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            SingleCallGraphFunctionTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.SECONDRAY_UNMATCHED.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

