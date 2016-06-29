/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.combined.flowgraph;

import com.google.security.zynamics.bindiff.enums.EMatchState;

class CombinedFlowGraphBasicBlockTreeNode$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState = new int[EMatchState.values().length];
        try {
            CombinedFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.MATCHED.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            CombinedFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.PRIMARY_UNMATCHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            CombinedFlowGraphBasicBlockTreeNode$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EMatchState[EMatchState.SECONDRAY_UNMATCHED.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

