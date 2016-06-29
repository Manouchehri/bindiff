/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.disassembly.GraphType$1;

public enum GraphType {
    CALLGRAPH,
    FLOWGRAPH,
    MIXED_GRAPH;
    

    private GraphType() {
    }

    public static String parseString(GraphType graphType) {
        switch (GraphType$1.$SwitchMap$com$google$security$zynamics$zylib$disassembly$GraphType[graphType.ordinal()]) {
            case 1: {
                return "Call graph";
            }
            case 2: {
                return "Flow graph";
            }
            case 3: {
                return "Mixed Graph";
            }
        }
        return "Unknown";
    }
}

