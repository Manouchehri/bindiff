package com.google.security.zynamics.zylib.gui.zygraph.layouters;

public enum HierarchicStyle
{
    OCTLINEAR_OPTIMAL("OCTLINEAR_OPTIMAL", 0), 
    ORTHOGONAL_OPTIMAL("ORTHOGONAL_OPTIMAL", 1), 
    POLYLINE_OPTIMAL("POLYLINE_OPTIMAL", 2), 
    OCTLINEAR_TOPMOST("OCTLINEAR_TOPMOST", 3), 
    ORTHOGONAL_TOPMOST("ORTHOGONAL_TOPMOST", 4), 
    POLYLINE_TOPMOST("POLYLINE_TOPMOST", 5), 
    OCTLINEAR_TIGHT_TREE("OCTLINEAR_TIGHT_TREE", 6), 
    ORTHOGONAL_TIGHT_TREE("ORTHOGONAL_TIGHT_TREE", 7), 
    POLYLINE_TIGHT_TREE("POLYLINE_TIGHT_TREE", 8), 
    OCTLINEAR_BFS("OCTLINEAR_BFS", 9), 
    ORTHOGONAL_BFS("ORTHOGONAL_BFS", 10), 
    POLYLINE_BFS("POLYLINE_BFS", 11);
    
    private HierarchicStyle(final String s, final int n) {
    }
    
    public static HierarchicStyle parseInt(final int n) {
        switch (n) {
            case 0: {
                return HierarchicStyle.OCTLINEAR_OPTIMAL;
            }
            case 1: {
                return HierarchicStyle.ORTHOGONAL_OPTIMAL;
            }
            case 2: {
                return HierarchicStyle.POLYLINE_OPTIMAL;
            }
            case 3: {
                return HierarchicStyle.OCTLINEAR_TOPMOST;
            }
            case 4: {
                return HierarchicStyle.ORTHOGONAL_TOPMOST;
            }
            case 5: {
                return HierarchicStyle.POLYLINE_TOPMOST;
            }
            case 6: {
                return HierarchicStyle.OCTLINEAR_TIGHT_TREE;
            }
            case 7: {
                return HierarchicStyle.ORTHOGONAL_TIGHT_TREE;
            }
            case 8: {
                return HierarchicStyle.POLYLINE_TIGHT_TREE;
            }
            case 9: {
                return HierarchicStyle.OCTLINEAR_BFS;
            }
            case 10: {
                return HierarchicStyle.ORTHOGONAL_BFS;
            }
            case 11: {
                return HierarchicStyle.POLYLINE_BFS;
            }
            default: {
                throw new IllegalStateException("Error: Invalid style");
            }
        }
    }
}
