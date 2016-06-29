package com.google.security.zynamics.bindiff.graph.filter.enums;

public enum EMatchStateFilter
{
    NONE("NONE", 0), 
    UNMATCHED("UNMATCHED", 1), 
    MATCHED("MATCHED", 2), 
    MATCHED_IDENTICAL("MATCHED_IDENTICAL", 3), 
    MATCHED_INSTRUCTION_CHANGES("MATCHED_INSTRUCTION_CHANGES", 4), 
    MATCHED_STRUTURAL_CHANGES("MATCHED_STRUTURAL_CHANGES", 5);
    
    private EMatchStateFilter(final String s, final int n) {
    }
}
