/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

class GraphsIntermediateListeners$InternalGraphVisibilityListener
implements IZyGraphVisibilityListener {
    private final BinDiffGraph graph;

    private GraphsIntermediateListeners$InternalGraphVisibilityListener(BinDiffGraph binDiffGraph) {
        this.graph = binDiffGraph;
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

    /* synthetic */ GraphsIntermediateListeners$InternalGraphVisibilityListener(BinDiffGraph binDiffGraph, GraphsIntermediateListeners$1 graphsIntermediateListeners$1) {
        this(binDiffGraph);
    }
}

