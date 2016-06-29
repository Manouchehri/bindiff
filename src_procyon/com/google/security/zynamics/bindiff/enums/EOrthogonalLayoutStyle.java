package com.google.security.zynamics.bindiff.enums;

public enum EOrthogonalLayoutStyle
{
    NORMAL("NORMAL", 0), 
    TREE("TREE", 1);
    
    private EOrthogonalLayoutStyle(final String s, final int n) {
    }
    
    public static EOrthogonalLayoutStyle getEnum(final int n) {
        return (n == 0) ? EOrthogonalLayoutStyle.NORMAL : EOrthogonalLayoutStyle.TREE;
    }
    
    public static int getOrdinal(final EOrthogonalLayoutStyle eOrthogonalLayoutStyle) {
        return (eOrthogonalLayoutStyle != EOrthogonalLayoutStyle.NORMAL) ? 1 : 0;
    }
}
