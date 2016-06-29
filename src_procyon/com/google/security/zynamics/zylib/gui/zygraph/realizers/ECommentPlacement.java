package com.google.security.zynamics.zylib.gui.zygraph.realizers;

public enum ECommentPlacement
{
    ABOVE_LINE("ABOVE_LINE", 0), 
    BEHIND_LINE("BEHIND_LINE", 1);
    
    private ECommentPlacement(final String s, final int n) {
    }
    
    public static int getOrdinal(final ECommentPlacement eCommentPlacement) {
        return (eCommentPlacement != ECommentPlacement.ABOVE_LINE) ? 1 : 0;
    }
    
    public static ECommentPlacement valueOf(final int n) {
        if (n == 0) {
            return ECommentPlacement.ABOVE_LINE;
        }
        if (n == 1) {
            return ECommentPlacement.BEHIND_LINE;
        }
        throw new IllegalStateException("Error: Unknown ordinal value.");
    }
}
