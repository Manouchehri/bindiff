/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$1;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$InternalGraphSelectionListener;
import com.google.security.zynamics.bindiff.graph.listeners.GraphsIntermediateListeners$InternalGraphVisibilityListener;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphSelectionListener;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import java.util.Iterator;

public class GraphsIntermediateListeners {
    private final BinDiffGraph graph;
    private final ListenerProvider intermediateSelectionListener = new ListenerProvider();
    private final ListenerProvider intermediateVisibilityListener = new ListenerProvider();
    private final GraphsIntermediateListeners$InternalGraphSelectionListener selectionListener;
    private final GraphsIntermediateListeners$InternalGraphVisibilityListener visibilityListener;
    private GraphsIntermediateListeners$InternalGraphSelectionListener[] savedSelectionListeners = new GraphsIntermediateListeners$InternalGraphSelectionListener[4];
    private GraphsIntermediateListeners$InternalGraphVisibilityListener[] savedVisibilityListeners = new GraphsIntermediateListeners$InternalGraphVisibilityListener[4];

    public GraphsIntermediateListeners(BinDiffGraph binDiffGraph) {
        Preconditions.checkNotNull(binDiffGraph);
        this.graph = binDiffGraph;
        this.selectionListener = new GraphsIntermediateListeners$InternalGraphSelectionListener(binDiffGraph, null);
        this.visibilityListener = new GraphsIntermediateListeners$InternalGraphVisibilityListener(binDiffGraph, null);
        this.addListeners();
    }

    public static void notifyIntermediateSelectionListeners(BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            binDiffGraph.getPrimaryGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            binDiffGraph.getSecondaryGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            binDiffGraph.getCombinedGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            binDiffGraph.getSuperGraph().getIntermediateListeners().notifyIntermediateSelectionListener();
            return;
        }
        binDiffGraph.getIntermediateListeners().notifyIntermediateSelectionListener();
    }

    public static void notifyIntermediateVisibilityListeners(BinDiffGraph binDiffGraph) {
        if (binDiffGraph.getSettings().isSync()) {
            binDiffGraph.getPrimaryGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            binDiffGraph.getSecondaryGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            binDiffGraph.getCombinedGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            binDiffGraph.getSuperGraph().getIntermediateListeners().notifyIntermediateVisibilityListener();
            return;
        }
        binDiffGraph.getIntermediateListeners().notifyIntermediateSelectionListener();
    }

    private void addListeners() {
        this.graph.addListener(this.selectionListener);
        this.graph.addListener(this.visibilityListener);
    }

    private GraphsIntermediateListeners getGraphIntermediateListener(EGraph eGraph) {
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
        }
        throw new IllegalStateException();
    }

    private GraphsIntermediateListeners$InternalGraphSelectionListener getSelectionListener() {
        return this.selectionListener;
    }

    private GraphsIntermediateListeners$InternalGraphVisibilityListener getVisibilityListener() {
        return this.visibilityListener;
    }

    private void notifyIntermediateSelectionListener() {
        Iterator iterator = this.intermediateSelectionListener.iterator();
        while (iterator.hasNext()) {
            IZyGraphSelectionListener iZyGraphSelectionListener = (IZyGraphSelectionListener)iterator.next();
            iZyGraphSelectionListener.selectionChanged();
        }
    }

    private void notifyIntermediateVisibilityListener() {
        Iterator iterator = this.intermediateVisibilityListener.iterator();
        while (iterator.hasNext()) {
            IZyGraphVisibilityListener iZyGraphVisibilityListener = (IZyGraphVisibilityListener)iterator.next();
            iZyGraphVisibilityListener.visibilityChanged();
        }
    }

    public void addIntermediateListener(IZyGraphSelectionListener iZyGraphSelectionListener) {
        this.intermediateSelectionListener.addListener(iZyGraphSelectionListener);
    }

    public void addIntermediateListener(IZyGraphVisibilityListener iZyGraphVisibilityListener) {
        this.intermediateVisibilityListener.addListener(iZyGraphVisibilityListener);
    }

    public void blockZyLibSelectionListeners() {
        this.savedSelectionListeners[0] = this.getGraphIntermediateListener(EGraph.PRIMARY_GRAPH).getSelectionListener();
        this.savedSelectionListeners[1] = this.getGraphIntermediateListener(EGraph.SECONDARY_GRAPH).getSelectionListener();
        this.savedSelectionListeners[2] = this.getGraphIntermediateListener(EGraph.SUPER_GRAPH).getSelectionListener();
        this.savedSelectionListeners[3] = this.getGraphIntermediateListener(EGraph.COMBINED_GRAPH).getSelectionListener();
        GraphsIntermediateListeners$InternalGraphSelectionListener[] arrgraphsIntermediateListeners$InternalGraphSelectionListener = this.savedSelectionListeners;
        int n2 = arrgraphsIntermediateListeners$InternalGraphSelectionListener.length;
        int n3 = 0;
        while (n3 < n2) {
            GraphsIntermediateListeners$InternalGraphSelectionListener graphsIntermediateListeners$InternalGraphSelectionListener = arrgraphsIntermediateListeners$InternalGraphSelectionListener[n3];
            if (graphsIntermediateListeners$InternalGraphSelectionListener != null) {
                graphsIntermediateListeners$InternalGraphSelectionListener.getGraph().removeListener(graphsIntermediateListeners$InternalGraphSelectionListener);
            }
            ++n3;
        }
    }

    public void blockZyLibVisibilityListeners() {
        this.savedVisibilityListeners[0] = this.getGraphIntermediateListener(EGraph.PRIMARY_GRAPH).getVisibilityListener();
        this.savedVisibilityListeners[1] = this.getGraphIntermediateListener(EGraph.SECONDARY_GRAPH).getVisibilityListener();
        this.savedVisibilityListeners[2] = this.getGraphIntermediateListener(EGraph.SUPER_GRAPH).getVisibilityListener();
        this.savedVisibilityListeners[3] = this.getGraphIntermediateListener(EGraph.COMBINED_GRAPH).getVisibilityListener();
        GraphsIntermediateListeners$InternalGraphVisibilityListener[] arrgraphsIntermediateListeners$InternalGraphVisibilityListener = this.savedVisibilityListeners;
        int n2 = arrgraphsIntermediateListeners$InternalGraphVisibilityListener.length;
        int n3 = 0;
        while (n3 < n2) {
            GraphsIntermediateListeners$InternalGraphVisibilityListener graphsIntermediateListeners$InternalGraphVisibilityListener = arrgraphsIntermediateListeners$InternalGraphVisibilityListener[n3];
            if (graphsIntermediateListeners$InternalGraphVisibilityListener != null) {
                graphsIntermediateListeners$InternalGraphVisibilityListener.getGraph().removeListener(graphsIntermediateListeners$InternalGraphVisibilityListener);
            }
            ++n3;
        }
    }

    public void dispose() {
        this.graph.removeListener(this.selectionListener);
        this.graph.removeListener(this.visibilityListener);
        this.savedSelectionListeners = null;
        this.savedVisibilityListeners = null;
    }

    public void freeZyLibSelectionListeners() {
        GraphsIntermediateListeners$InternalGraphSelectionListener[] arrgraphsIntermediateListeners$InternalGraphSelectionListener = this.savedSelectionListeners;
        int n2 = arrgraphsIntermediateListeners$InternalGraphSelectionListener.length;
        int n3 = 0;
        while (n3 < n2) {
            GraphsIntermediateListeners$InternalGraphSelectionListener graphsIntermediateListeners$InternalGraphSelectionListener = arrgraphsIntermediateListeners$InternalGraphSelectionListener[n3];
            if (graphsIntermediateListeners$InternalGraphSelectionListener != null) {
                graphsIntermediateListeners$InternalGraphSelectionListener.getGraph().addListener(graphsIntermediateListeners$InternalGraphSelectionListener);
            }
            ++n3;
        }
    }

    public void freeZyLibVisibilityListeners() {
        GraphsIntermediateListeners$InternalGraphVisibilityListener[] arrgraphsIntermediateListeners$InternalGraphVisibilityListener = this.savedVisibilityListeners;
        int n2 = arrgraphsIntermediateListeners$InternalGraphVisibilityListener.length;
        int n3 = 0;
        while (n3 < n2) {
            GraphsIntermediateListeners$InternalGraphVisibilityListener graphsIntermediateListeners$InternalGraphVisibilityListener = arrgraphsIntermediateListeners$InternalGraphVisibilityListener[n3];
            if (graphsIntermediateListeners$InternalGraphVisibilityListener != null) {
                graphsIntermediateListeners$InternalGraphVisibilityListener.getGraph().addListener(graphsIntermediateListeners$InternalGraphVisibilityListener);
            }
            ++n3;
        }
    }

    public void removeIntermediateListener(IZyGraphSelectionListener iZyGraphSelectionListener) {
        this.intermediateSelectionListener.removeListener(iZyGraphSelectionListener);
    }

    public void removeIntermediateListener(IZyGraphVisibilityListener iZyGraphVisibilityListener) {
        this.intermediateVisibilityListener.removeListener(iZyGraphVisibilityListener);
    }
}

