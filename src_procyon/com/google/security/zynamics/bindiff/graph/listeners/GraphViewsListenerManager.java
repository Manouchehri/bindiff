package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.log.*;

public class GraphViewsListenerManager
{
    private final GraphsContainer graphs;
    private final SingleViewCanvasListener primaryViewCanvasListener;
    private final SingleViewCanvasListener secondaryViewCanvasListener;
    private final CombinedGraphMouseListener combinedGraphMouseListener;
    private final SingleGraphMouseListener primaryGraphMouseListener;
    private final SingleGraphMouseListener secondaryGraphMouseListener;
    private final SingleViewFocusListener primaryViewFocusListener;
    private final SingleViewFocusListener secondaryViewFocusListener;
    
    public GraphViewsListenerManager(final GraphsContainer graphs, final ViewTabPanelFunctions viewTabPanelFunctions) {
        Preconditions.checkNotNull(graphs);
        Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graphs = graphs;
        this.primaryViewCanvasListener = new SingleViewCanvasListener(viewTabPanelFunctions, graphs.getPrimaryGraph());
        this.secondaryViewCanvasListener = new SingleViewCanvasListener(viewTabPanelFunctions, graphs.getSecondaryGraph());
        this.combinedGraphMouseListener = new CombinedGraphMouseListener(viewTabPanelFunctions, graphs.getCombinedGraph());
        this.primaryGraphMouseListener = new SingleGraphMouseListener(viewTabPanelFunctions, graphs.getPrimaryGraph());
        this.secondaryGraphMouseListener = new SingleGraphMouseListener(viewTabPanelFunctions, graphs.getSecondaryGraph());
        this.primaryViewFocusListener = new SingleViewFocusListener(viewTabPanelFunctions, graphs.getPrimaryGraph());
        this.secondaryViewFocusListener = new SingleViewFocusListener(viewTabPanelFunctions, graphs.getSecondaryGraph());
    }
    
    public void addGraphMouseListener(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph == this.graphs.getPrimaryGraph()) {
            this.primaryGraphMouseListener.addListener();
        }
        else if (binDiffGraph == this.graphs.getSecondaryGraph()) {
            this.secondaryGraphMouseListener.addListener();
        }
        else if (binDiffGraph == this.graphs.getCombinedGraph()) {
            this.combinedGraphMouseListener.addListener();
        }
        else {
            Logger.logWarning("Unknown graph! Add graph mouse listener was ignored.", new Object[0]);
        }
    }
    
    public void addViewCanvasListener(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph == this.graphs.getPrimaryGraph()) {
            this.primaryViewCanvasListener.addListener();
        }
        else if (binDiffGraph == this.graphs.getSecondaryGraph()) {
            this.secondaryViewCanvasListener.addListener();
        }
        else {
            Logger.logWarning("Unknown graph! Add view canvas listener was ignored.", new Object[0]);
        }
    }
    
    public void addViewFocusListener(final BinDiffGraph binDiffGraph) {
        if (binDiffGraph == this.graphs.getPrimaryGraph()) {
            this.primaryViewFocusListener.addListener();
        }
        else if (binDiffGraph == this.graphs.getSecondaryGraph()) {
            this.secondaryViewFocusListener.addListener();
        }
        else {
            Logger.logWarning("Unknown graph! Add graph view focus listener was ignored.", new Object[0]);
        }
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
    
    public void removeGraphMouseListener(final BinDiffGraph binDiffGraph) {
        try {
            if (binDiffGraph == this.graphs.getPrimaryGraph()) {
                this.primaryGraphMouseListener.removeListener();
            }
            else if (binDiffGraph == this.graphs.getSecondaryGraph()) {
                this.secondaryGraphMouseListener.removeListener();
            }
            else if (binDiffGraph == this.graphs.getCombinedGraph()) {
                this.combinedGraphMouseListener.removeListener();
            }
            else {
                Logger.logWarning("Unknown graph! Remove graph mouse listener was ignored.", new Object[0]);
            }
        }
        catch (IllegalStateException ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    public void removeViewCanvasListener(final BinDiffGraph binDiffGraph) {
        try {
            if (binDiffGraph == this.graphs.getPrimaryGraph()) {
                this.primaryViewCanvasListener.removeListener();
            }
            else if (binDiffGraph == this.graphs.getSecondaryGraph()) {
                this.secondaryViewCanvasListener.removeListener();
            }
            else {
                Logger.logWarning("Unknown graph! Remove view canvas listener was ignored.", new Object[0]);
            }
        }
        catch (IllegalStateException ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    public void removeViewFocusListener(final BinDiffGraph binDiffGraph) {
        try {
            if (binDiffGraph == this.graphs.getPrimaryGraph()) {
                this.primaryViewFocusListener.addListener();
            }
            else if (binDiffGraph == this.graphs.getSecondaryGraph()) {
                this.secondaryViewFocusListener.addListener();
            }
            else {
                Logger.logWarning("Unknown graph! Add graph view focus listener was ignored.", new Object[0]);
            }
        }
        catch (IllegalStateException ex) {
            Logger.logWarning("Listener was not listening.", new Object[0]);
        }
    }
    
    public void suppressUpdating(final boolean b) {
        this.primaryViewCanvasListener.suppressUpdateGraph(b);
        this.secondaryViewCanvasListener.suppressUpdateGraph(b);
    }
}
