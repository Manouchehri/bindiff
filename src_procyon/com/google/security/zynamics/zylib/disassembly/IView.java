package com.google.security.zynamics.zylib.disassembly;

import com.google.security.zynamics.zylib.types.graphs.*;

public interface IView
{
    void addListener(final IViewListener p0);
    
    boolean close();
    
    int getEdgeCount();
    
    IDirectedGraph getGraph();
    
    GraphType getGraphType();
    
    String getName();
    
    int getNodeCount();
    
    ViewType getType();
    
    boolean isLoaded();
    
    void removeListener(final IViewListener p0);
}
