package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum HierarchicOrientation
{
    VERTICAL("VERTICAL", 0), 
    HORIZONTAL("HORIZONTAL", 1);
    
    private HierarchicOrientation(final String s, final int n) {
    }
    
    public static HierarchicOrientation parseInt(final int n) {
        if (n == HierarchicOrientation.VERTICAL.ordinal()) {
            return HierarchicOrientation.VERTICAL;
        }
        if (n == HierarchicOrientation.HORIZONTAL.ordinal()) {
            return HierarchicOrientation.HORIZONTAL;
        }
        throw new IllegalStateException("Internal Error: Invalid orientation value");
    }
}
