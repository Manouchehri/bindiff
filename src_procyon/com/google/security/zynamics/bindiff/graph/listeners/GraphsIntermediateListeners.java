package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.*;

public class GraphsIntermediateListeners
{
    private final BinDiffGraph graph;
    private final ListenerProvider intermediateSelectionListener;
    private final ListenerProvider intermediateVisibilityListener;
    private final GraphsIntermediateListeners$InternalGraphSelectionListener selectionListener;
    private final GraphsIntermediateListeners$InternalGraphVisibilityListener visibilityListener;
    private GraphsIntermediateListeners$InternalGraphSelectionListener[] savedSelectionListeners;
    private GraphsIntermediateListeners$InternalGraphVisibilityListener[] savedVisibilityListeners;
    
    public GraphsIntermediateListeners(final BinDiffGraph graph) {
        this.intermediateSelectionListener = new ListenerProvider();
        this.intermediateVisibilityListener = new ListenerProvider();
        this.savedSelectionListeners = new GraphsIntermediateListeners$InternalGraphSelectionListener[4];
        this.savedVisibilityListeners = new GraphsIntermediateListeners$InternalGraphVisibilityListener[4];
        Preconditions.checkNotNull(graph);
        this.graph = graph;
        this.selectionListener = new GraphsIntermediateListeners$InternalGraphSelectionListener(graph, null);
        this.visibilityListener = new GraphsIntermediateListeners$InternalGraphVisibilityListener(graph, null);
        this.addListeners();
    }
    
    public static void notifyIntermediateSelectionListeners(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            binDiffGraph.getPrimaryGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            binDiffGraph.getSecondaryGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            binDiffGraph.getCombinedGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            binDiffGraph.getSuperGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
        }
        else {
            binDiffGraph.getIntermediateListeners().notifyIntermediateSelectionListener();
        }
    }
    
    public static void notifyIntermediateVisibilityListeners(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            binDiffGraph.getPrimaryGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            binDiffGraph.getSecondaryGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            binDiffGraph.getCombinedGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            binDiffGraph.getSuperGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
        }
        else {
            binDiffGraph.getIntermediateListeners().notifyIntermediateSelectionListener();
        }
    }
    
    private void addListeners() {
        this.graph.addListener(this.selectionListener);
        this.graph.addListener(this.visibilityListener);
    }
    
    private GraphsIntermediateListeners getGraphIntermediateListener(final EGraph eGraph) {
        Preconditions.checkNotNull(this.graph);
        switch (GraphsIntermediateListeners$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraph[eGraph.ordinal()]) {
            case 1: {
                Preconditions.checkNotNull(this.graph.getPrimaryGraph());
                return this.graph.getPrimaryGraph().getIntermediateListeners();
            }
            case 2: {
                Preconditions.checkNotNull(this.graph.getSecondaryGraph());
                return this.graph.getSecondaryGraph().getIntermediateListeners();
            }
            case 3: {
                Preconditions.checkNotNull(this.graph.getCombinedGraph());
                return this.graph.getCombinedGraph().getIntermediateListeners();
            }
            case 4: {
                Preconditions.checkNotNull(this.graph.getSuperGraph());
                return this.graph.getSuperGraph().getIntermediateListeners();
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }
    
    private GraphsIntermediateListeners$InternalGraphSelectionListener getSelectionListener() {
        return this.selectionListener;
    }
    
    private GraphsIntermediateListeners$InternalGraphVisibilityListener getVisibilityListener() {
        return this.visibilityListener;
    }
    
    private void notifyIntermediateSelectionListener() {
        final Iterator iterator = this.intermediateSelectionListener.iterator();
        while (iterator.hasNext()) {
            iterator.next().selectionChanged();
        }
    }
    
    private void notifyIntermediateVisibilityListener() {
        final Iterator iterator = this.intermediateVisibilityListener.iterator();
        while (iterator.hasNext()) {
            iterator.next().visibilityChanged();
        }
    }
    
    public void addIntermediateListener(final IZyGraphSelectionListener zyGraphSelectionListener) {
        this.intermediateSelectionListener.addListener(zyGraphSelectionListener);
    }
    
    public void addIntermediateListener(final IZyGraphVisibilityListener zyGraphVisibilityListener) {
        this.intermediateVisibilityListener.addListener(zyGraphVisibilityListener);
    }
    
    public void blockZyLibSelectionListeners() {
        this.savedSelectionListeners[0] = this.getGraphIntermediateListener(EGraph.PRIMARY_GRAPH).getSelectionListener();
        this.savedSelectionListeners[1] = this.getGraphIntermediateListener(EGraph.SECONDARY_GRAPH).getSelectionListener();
        this.savedSelectionListeners[2] = this.getGraphIntermediateListener(EGraph.SUPER_GRAPH).getSelectionListener();
        this.savedSelectionListeners[3] = this.getGraphIntermediateListener(EGraph.COMBINED_GRAPH).getSelectionListener();
        for (final GraphsIntermediateListeners$InternalGraphSelectionListener graphsIntermediateListeners$InternalGraphSelectionListener : this.savedSelectionListeners) {
            if (graphsIntermediateListeners$InternalGraphSelectionListener != null) {
                graphsIntermediateListeners$InternalGraphSelectionListener.getGraph().removeListener(graphsIntermediateListeners$InternalGraphSelectionListener);
            }
        }
    }
    
    public void blockZyLibVisibilityListeners() {
        this.savedVisibilityListeners[0] = this.getGraphIntermediateListener(EGraph.PRIMARY_GRAPH).getVisibilityListener();
        this.savedVisibilityListeners[1] = this.getGraphIntermediateListener(EGraph.SECONDARY_GRAPH).getVisibilityListener();
        this.savedVisibilityListeners[2] = this.getGraphIntermediateListener(EGraph.SUPER_GRAPH).getVisibilityListener();
        this.savedVisibilityListeners[3] = this.getGraphIntermediateListener(EGraph.COMBINED_GRAPH).getVisibilityListener();
        for (final GraphsIntermediateListeners$InternalGraphVisibilityListener graphsIntermediateListeners$InternalGraphVisibilityListener : this.savedVisibilityListeners) {
            if (graphsIntermediateListeners$InternalGraphVisibilityListener != null) {
                graphsIntermediateListeners$InternalGraphVisibilityListener.getGraph().removeListener(graphsIntermediateListeners$InternalGraphVisibilityListener);
            }
        }
    }
    
    public void dispose() {
        this.graph.removeListener(this.selectionListener);
        this.graph.removeListener(this.visibilityListener);
        this.savedSelectionListeners = null;
        this.savedVisibilityListeners = null;
    }
    
    public void freeZyLibSelectionListeners() {
        for (final GraphsIntermediateListeners$InternalGraphSelectionListener graphsIntermediateListeners$InternalGraphSelectionListener : this.savedSelectionListeners) {
            if (graphsIntermediateListeners$InternalGraphSelectionListener != null) {
                graphsIntermediateListeners$InternalGraphSelectionListener.getGraph().addListener(graphsIntermediateListeners$InternalGraphSelectionListener);
            }
        }
    }
    
    public void freeZyLibVisibilityListeners() {
        for (final GraphsIntermediateListeners$InternalGraphVisibilityListener graphsIntermediateListeners$InternalGraphVisibilityListener : this.savedVisibilityListeners) {
            if (graphsIntermediateListeners$InternalGraphVisibilityListener != null) {
                graphsIntermediateListeners$InternalGraphVisibilityListener.getGraph().addListener(graphsIntermediateListeners$InternalGraphVisibilityListener);
            }
        }
    }
    
    public void removeIntermediateListener(final IZyGraphSelectionListener zyGraphSelectionListener) {
        this.intermediateSelectionListener.removeListener(zyGraphSelectionListener);
    }
    
    public void removeIntermediateListener(final IZyGraphVisibilityListener zyGraphVisibilityListener) {
        this.intermediateVisibilityListener.removeListener(zyGraphVisibilityListener);
    }
}
