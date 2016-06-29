package com.google.security.zynamics.bindiff.enums;

public enum EViewMatchType
{
    CALLGRAPH("CALLGRAPH", 0), 
    MATCHED_FLOWGRAPH("MATCHED_FLOWGRAPH", 1), 
    PRIMARY_UNMATCHED_FLOWGRAPH("PRIMARY_UNMATCHED_FLOWGRAPH", 2), 
    SECONDARY_UNMATCHED_FLOWGRAPH("SECONDARY_UNMATCHED_FLOWGRAPH", 3);
    
    private EViewMatchType(final String s, final int n) {
    }
}
