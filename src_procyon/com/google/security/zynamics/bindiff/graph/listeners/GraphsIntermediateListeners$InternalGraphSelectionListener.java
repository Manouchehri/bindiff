package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;

class GraphsIntermediateListeners$InternalGraphSelectionListener implements IZyGraphSelectionListener
{
    private final BinDiffGraph graph;
    
    private GraphsIntermediateListeners$InternalGraphSelectionListener(final BinDiffGraph graph) {
        this.graph = graph;
    }
    
    public BinDiffGraph getGraph() {
        return this.graph;
    }
    
    @Override
    public void selectionChanged() {
        GraphLayoutEventHandler.handleSelectionChangedEvent(this.graph, true);
    }
}
