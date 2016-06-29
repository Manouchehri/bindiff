package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum OrthogonalStyle
{
    NORMAL("NORMAL", 0), 
    TREE("TREE", 1);
    
    private OrthogonalStyle(final String s, final int n) {
    }
    
    public static OrthogonalStyle parseInt(final int n) {
        if (n == OrthogonalStyle.NORMAL.ordinal()) {
            return OrthogonalStyle.NORMAL;
        }
        if (n == OrthogonalStyle.TREE.ordinal()) {
            return OrthogonalStyle.TREE;
        }
        throw new IllegalStateException(new StringBuilder(32).append("Error: Invalid style ").append(n).toString());
    }
}
