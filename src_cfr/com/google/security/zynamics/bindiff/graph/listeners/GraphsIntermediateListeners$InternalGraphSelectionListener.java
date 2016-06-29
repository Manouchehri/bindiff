/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;

class GraphsIntermediateListeners$InternalGraphSelectionListener
implements IZyGraphSelectionListener {
    private final BinDiffGraph graph;

    private GraphsIntermediateListeners$InternalGraphSelectionListener(BinDiffGraph binDiffGraph) {
        this.graph = binDiffGraph;
    }

    public BinDiffGraph getGraph() {
        return this.graph;
    }

    @Override
    public void selectionChanged() {
        GraphLayoutEventHandler.handleSelectionChangedEvent(this.graph, true);
    }

    /* synthetic */ GraphsIntermediateListeners$InternalGraphSelectionListener(BinDiffGraph binDiffGraph, GraphsIntermediateListeners$1 graphsIntermediateListeners$1) {
        this(binDiffGraph);
    }
}

