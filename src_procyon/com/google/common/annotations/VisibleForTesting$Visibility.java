package com.google.common.annotations;

@GoogleInternal
public enum VisibleForTesting$Visibility
{
    NONE("NONE", 0), 
    PRIVATE("PRIVATE", 1), 
    PACKAGE_PRIVATE("PACKAGE_PRIVATE", 2), 
    PROTECTED("PROTECTED", 3);
    
    private VisibleForTesting$Visibility(final String s, final int n) {
    }
}
