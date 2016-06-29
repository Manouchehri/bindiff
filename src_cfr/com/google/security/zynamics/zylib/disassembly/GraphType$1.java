/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.GraphType;

class GraphType$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType;

    static {
        $SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType = new int[GraphType.values().length];
        try {
            GraphType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[GraphType.CALLGRAPH.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            GraphType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[GraphType.FLOWGRAPH.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            GraphType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[GraphType.MIXED_GRAPH.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
    }
}

