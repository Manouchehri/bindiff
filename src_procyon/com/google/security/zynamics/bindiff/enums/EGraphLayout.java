package com.google.security.zynamics.bindiff.enums;

public enum EGraphLayout
{
    HIERARCHICAL("HIERARCHICAL", 0), 
    ORTHOGONAL("ORTHOGONAL", 1), 
    CIRCULAR("CIRCULAR", 2);
    
    private EGraphLayout(final String s, final int n) {
    }
    
    public static EGraphLayout getEnum(final int n) {
        switch (n) {
            case 0: {
                return EGraphLayout.HIERARCHICAL;
            }
            case 1: {
                return EGraphLayout.ORTHOGONAL;
            }
            case 2: {
                return EGraphLayout.CIRCULAR;
            }
            default: {
                throw new IllegalArgumentException("Unknown layout style.");
            }
        }
    }
    
    public static int getOrdinal(final EGraphLayout eGraphLayout) {
        switch (EGraphLayout$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[eGraphLayout.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            default: {
                throw new IllegalArgumentException("Unknown layout style.");
            }
        }
    }
}
