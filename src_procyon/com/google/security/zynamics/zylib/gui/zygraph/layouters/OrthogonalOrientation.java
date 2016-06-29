package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum OrthogonalOrientation
{
    VERTICAL("VERTICAL", 0), 
    HORIZONTAL("HORIZONTAL", 1);
    
    private OrthogonalOrientation(final String s, final int n) {
    }
    
    public static OrthogonalOrientation parseInt(final int n) {
        if (n == OrthogonalOrientation.VERTICAL.ordinal()) {
            return OrthogonalOrientation.VERTICAL;
        }
        if (n == OrthogonalOrientation.HORIZONTAL.ordinal()) {
            return OrthogonalOrientation.HORIZONTAL;
        }
        throw new IllegalStateException("Internal Error: Unknown orientation");
    }
}
