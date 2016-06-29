package com.google.security.zynamics.bindiff.enums;

public enum EGraph
{
    PRIMARY_GRAPH("PRIMARY_GRAPH", 0), 
    SECONDARY_GRAPH("SECONDARY_GRAPH", 1), 
    COMBINED_GRAPH("COMBINED_GRAPH", 2), 
    SUPER_GRAPH("SUPER_GRAPH", 3);
    
    private EGraph(final String s, final int n) {
    }
}
