package com.google.security.zynamics.bindiff.enums;

public enum EMatchType
{
    IDENTICAL("IDENTICAL", 0), 
    INSTRUCTIONS_CHANGED("INSTRUCTIONS_CHANGED", 1), 
    STRUCTURAL_CHANGED("STRUCTURAL_CHANGED", 2), 
    UNUMATCHED("UNUMATCHED", 3);
    
    private EMatchType(final String s, final int n) {
    }
}
