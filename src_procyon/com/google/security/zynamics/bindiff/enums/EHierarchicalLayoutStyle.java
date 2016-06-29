package com.google.security.zynamics.bindiff.enums;

public enum EHierarchicalLayoutStyle
{
    PENDULUM_MULTILINE("PENDULUM_MULTILINE", 0), 
    PENDULUM_ORTHOGONAL("PENDULUM_ORTHOGONAL", 1), 
    LINEAR_SEGMEMENTS_MULTILINE("LINEAR_SEGMEMENTS_MULTILINE", 2), 
    LINEAR_SEGMENTS_ORTHOGONAL("LINEAR_SEGMENTS_ORTHOGONAL", 3);
    
    private EHierarchicalLayoutStyle(final String s, final int n) {
    }
    
    public static EHierarchicalLayoutStyle getEnum(final int n) {
        switch (n) {
            case 0: {
                return EHierarchicalLayoutStyle.PENDULUM_MULTILINE;
            }
            case 1: {
                return EHierarchicalLayoutStyle.PENDULUM_ORTHOGONAL;
            }
            case 2: {
                return EHierarchicalLayoutStyle.LINEAR_SEGMEMENTS_MULTILINE;
            }
            case 3: {
                return EHierarchicalLayoutStyle.LINEAR_SEGMENTS_ORTHOGONAL;
            }
            default: {
                throw new IllegalArgumentException("Unknown hierarchical layout style.");
            }
        }
    }
    
    public static int getOrdinal(final EHierarchicalLayoutStyle eHierarchicalLayoutStyle) {
        switch (EHierarchicalLayoutStyle$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EHierarchicalLayoutStyle[eHierarchicalLayoutStyle.ordinal()]) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            default: {
                throw new IllegalArgumentException("Unknown hierarchical layout style.");
            }
        }
    }
}
