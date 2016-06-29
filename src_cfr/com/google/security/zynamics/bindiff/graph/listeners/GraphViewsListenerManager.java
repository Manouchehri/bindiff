/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.listeners.CombinedGraphMouseListener;
import com.google.security.zynamics.bindiff.graph.listeners.SingleGraphMouseListener;
import com.google.security.zynamics.bindiff.graph.listeners.SingleViewCanvasListener;
import com.google.security.zynamics.bindiff.graph.listeners.SingleViewFocusListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.log.Logger;

public class GraphViewsListenerManager {
    private final GraphsContainer graphs;
    private final SingleViewCanvasListener primaryViewCanvasListener;
    private final SingleViewCanvasListener secondaryViewCanvasListener;
    private final CombinedGraphMouseListener combinedGraphMouseListener;
    private final SingleGraphMouseListener primaryGraphMouseListener;
    private final SingleGraphMouseListener secondaryGraphMouseListener;
    private final SingleViewFocusListener primaryViewFocusListener;
    private final SingleViewFocusListener secondaryViewFocusListener;

    public GraphViewsListenerManager(GraphsContainer graphsContainer, ViewTabPanelFunctions viewTabPanelFunctions) {
        Preconditions.checkNotNull(graphsContainer);
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graphs = graphsContainer;
        this.primaryViewCanvasListener = new SingleViewCanvasListener(viewTabPanelFunctions, graphsContainer.getPrimaryGraph());
        this.secondaryViewCanvasListener = new SingleViewCanvasListener(viewTabPanelFunctions, graphsContainer.getSecondaryGraph());
        this.combinedGraphMouseListener = new CombinedGraphMouseListener(viewTabPanelFunctions, graphsContainer.getCombinedGraph());
        this.primaryGraphMouseListener = new SingleGraphMouseListener(viewTabPanelFunctions, graphsContainer.getPrimaryGraph());
        this.secondaryGraphMouseListener = new SingleGraphMouseListener(viewTabPanelFunctions, graphsContainer.getSecondaryGraph());
        this.primaryViewFocusListener = new SingleViewFocusListener(viewTabPanelFunctions, graphsContainer.getPrimaryGraph());
        this.secondaryViewFocusListener = new SingleViewFocusListener(viewTabPanelFunctions, graphsContainer.getSecondaryGraph());
    }

    public void addGraphMouseListener(BinDiffGraph binDiffGraph) {
        if (binDiffGraph == this.graphs.getPrimaryGraph()) {
            this.primaryGraphMouseListener.addListener();
            return;
        }
        if (binDiffGraph == this.graphs.getSecondaryGraph()) {
            this.secondaryGraphMouseListener.addListener();
            return;
        }
        if (binDiffGraph == this.graphs.getCombinedGraph()) {
            this.combinedGraphMouseListener.addListener();
            return;
        }
        Logger.logWarning("Unknown graph! Add graph mouse listener was ignored.", new Object[0]);
    }

    public void addViewCanvasListener(BinDiffGraph binDiffGraph) {
        if (binDiffGraph == this.graphs.getPrimaryGraph()) {
            this.primaryViewCanvasListener.addListener();
            return;
        }
        if (binDiffGraph == this.graphs.getSecondaryGraph()) {
            this.secondaryViewCanvasListener.addListener();
            return;
        }
        Logger.logWarning("Unknown graph! Add view canvas listener was ignored.", new Object[0]);
    }

    public void addViewFocusListener(BinDiffGraph binDiffGraph) {
        if (binDiffGraph == this.graphs.getPrimaryGraph()) {
            this.primaryViewFocusListener.addListener();
            return;
        }
        if (binDiffGraph == this.graphs.getSecondaryGraph()) {
            this.secondaryViewFocusListener.addListener();
            return;
        }
        Logger.logWarning("Unknown graph! Add graph view focus listener was ignored.", new Object[0]);
    }

    public void dispose() {
        this.removeViewCanvasListener(this.graphs.getPrimaryGraph());
        this.removeViewCanvasListener(this.graphs.getSecondaryGraph());
        this.removeViewFocusListener(this.graphs.getPrimaryGraph());
        this.removeViewFocusListener(this.graphs.getSecondaryGraph());
        this.removeGraphMouseListener(this.graphs.getPrimaryGraph());
        this.removeGraphMouseListener(this.graphs.getSecondaryGraph());
        this.removeGraphMouseListener(this.graphs.getCombinedGraph());
    }

    public void removeGraphMouseListener(BinDiffGraph binDiffGraph) {
        try {
            if (binDiffGraph == this.graphs.getPrimaryGraph()) {
                this.primaryGraphMouseListener.removeListener();
                return;
            }
            if (binDiffGraph == this.graphs.getSecondaryGraph()) {
                this.secondaryGraphMouseListener.removeListener();
                return;
            }
            if (binDiffGraph == this.graphs.getCombinedGraph()) {
                this.combinedGraphMouseListener.removeListener();
                return;
            }
            Logger.logWarning("Unknown graph! Remove graph mouse listener was ignored.", new Object[0]);
            return;
        }
        catch (IllegalStateException var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    public void removeViewCanvasListener(BinDiffGraph binDiffGraph) {
        try {
            if (binDiffGraph == this.graphs.getPrimaryGraph()) {
                this.primaryViewCanvasListener.removeListener();
                return;
            }
            if (binDiffGraph == this.graphs.getSecondaryGraph()) {
                this.secondaryViewCanvasListener.removeListener();
                return;
            }
            Logger.logWarning("Unknown graph! Remove view canvas listener was ignored.", new Object[0]);
            return;
        }
        catch (IllegalStateException var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    public void removeViewFocusListener(BinDiffGraph binDiffGraph) {
        try {
            if (binDiffGraph == this.graphs.getPrimaryGraph()) {
                this.primaryViewFocusListener.addListener();
                return;
            }
            if (binDiffGraph == this.graphs.getSecondaryGraph()) {
                this.secondaryViewFocusListener.addListener();
                return;
            }
            Logger.logWarning("Unknown graph! Add graph view focus listener was ignored.", new Object[0]);
            return;
        }
        catch (IllegalStateException var2_2) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }

    public void suppressUpdating(boolean bl2) {
        this.primaryViewCanvasListener.suppressUpdateGraph(bl2);
        this.secondaryViewCanvasListener.suppressUpdateGraph(bl2);
    }
}

