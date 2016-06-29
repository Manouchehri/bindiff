package com.google.security.zynamics.bindiff.enums;

public enum EViewType
{
    CALLGRAPH_DIFF_VIEW("CALLGRAPH_DIFF_VIEW", 0), 
    FUNCTION_DIFF_VIEW("FUNCTION_DIFF_VIEW", 1), 
    SINGLE_FUNCTION_DIFF_VIEW("SINGLE_FUNCTION_DIFF_VIEW", 2);
    
    private EViewType(final String s, final int n) {
    }
}
