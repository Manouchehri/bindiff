package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum CircularStyle
{
    COMPACT("COMPACT", 0), 
    ISOLATED("ISOLATED", 1), 
    SINGLE_CIRCLE("SINGLE_CIRCLE", 2);
    
    private CircularStyle(final String s, final int n) {
    }
    
    public static CircularStyle parseInt(final int n) {
        if (n == CircularStyle.COMPACT.ordinal()) {
            return CircularStyle.COMPACT;
        }
        if (n == CircularStyle.ISOLATED.ordinal()) {
            return CircularStyle.ISOLATED;
        }
        if (n == CircularStyle.SINGLE_CIRCLE.ordinal()) {
            return CircularStyle.SINGLE_CIRCLE;
        }
        throw new IllegalStateException("Error: Invalid style");
    }
}
