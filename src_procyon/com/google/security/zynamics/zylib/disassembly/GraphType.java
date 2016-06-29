package com.google.security.zynamics.zylib.disassembly;

public enum GraphType
{
    CALLGRAPH("CALLGRAPH", 0), 
    FLOWGRAPH("FLOWGRAPH", 1), 
    MIXED_GRAPH("MIXED_GRAPH", 2);
    
    private GraphType(final String s, final int n) {
    }
    
    public static String parseString(final GraphType graphType) {
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
            default: {
                return "Unknown";
            }
        }
    }
}
