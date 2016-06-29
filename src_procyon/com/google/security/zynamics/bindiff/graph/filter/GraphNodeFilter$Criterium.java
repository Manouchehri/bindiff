package com.google.security.zynamics.bindiff.graph.filter;

public enum GraphNodeFilter$Criterium
{
    VISIBLE("VISIBLE", 0), 
    INVISIBLE("INVISIBLE", 1), 
    SELECTED("SELECTED", 2), 
    SELECTED_VISIBLE("SELECTED_VISIBLE", 3), 
    UNSELECTED_VISIBLE("UNSELECTED_VISIBLE", 4);
    
    private GraphNodeFilter$Criterium(final String s, final int n) {
    }
}
