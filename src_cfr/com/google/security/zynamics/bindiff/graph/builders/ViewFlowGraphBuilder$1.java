/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.builders;

import com.google.security.zynamics.bindiff.enums.EJumpType;

class ViewFlowGraphBuilder$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType;

    static {
        $SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType = new int[EJumpType.values().length];
        try {
            ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[EJumpType.JUMP_TRUE.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[EJumpType.JUMP_FALSE.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            ViewFlowGraphBuilder$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EJumpType[EJumpType.SWITCH.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

