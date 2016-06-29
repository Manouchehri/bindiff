package com.google.security.zynamics.bindiff.enums;

public enum ELayoutOrientation
{
    VERTICAL("VERTICAL", 0), 
    HORIZONTAL("HORIZONTAL", 1);
    
    private ELayoutOrientation(final String s, final int n) {
    }
    
    public static ELayoutOrientation getEnum(final int n) {
        return (n == 0) ? ELayoutOrientation.VERTICAL : ELayoutOrientation.HORIZONTAL;
    }
    
    public static int getOrdinal(final ELayoutOrientation eLayoutOrientation) {
        return (eLayoutOrientation != ELayoutOrientation.VERTICAL) ? 1 : 0;
    }
}
