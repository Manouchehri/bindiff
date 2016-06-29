package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.*;

class GraphsIntermediateListeners$InternalGraphVisibilityListener implements IZyGraphVisibilityListener
{
    private final BinDiffGraph graph;
    
    private GraphsIntermediateListeners$InternalGraphVisibilityListener(final BinDiffGraph graph) {
        this.graph = graph;
    }
    
    public BinDiffGraph getGraph() {
        return this.graph;
    }
    
    @Override
    public void nodeDeleted() {
    }
    
    @Override
    public void visibilityChanged() {
    }
}
