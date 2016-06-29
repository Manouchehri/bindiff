package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import java.beans.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.synchronizer.*;
import java.awt.geom.*;

public class SingleViewCanvasListener implements PropertyChangeListener
{
    private final SingleGraph graph;
    private final ViewTabPanelFunctions viewPanelController;
    private boolean suppressUpdateGraph;
    
    protected SingleViewCanvasListener(final ViewTabPanelFunctions viewPanelController, final SingleGraph graph) {
        this.suppressUpdateGraph = false;
        Preconditions.checkNotNull(viewPanelController);
        Preconditions.checkNotNull(graph);
        this.viewPanelController = viewPanelController;
        this.graph = graph;
        this.addListener();
    }
    
    public void addListener() {
        this.graph.getView().getCanvasComponent().addPropertyChangeListener(this);
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (this.graph.getGraphType() == EGraphType.FLOWGRAPH && this.graph.getFunctionAddress() == null) {
            return;
        }
        if ("Zoom".equals(propertyChangeEvent.getPropertyName())) {
            GraphViewCanvasSynchronizer.adoptZoom(this.viewPanelController.getGraphListenerManager(), this.graph);
        }
        else if ("ViewPoint".equals(propertyChangeEvent.getPropertyName())) {
            GraphViewCanvasSynchronizer.adoptViewPoint(this.viewPanelController.getGraphListenerManager(), this.graph, (Point2D)propertyChangeEvent.getOldValue(), this.suppressUpdateGraph);
        }
    }
    
    public void removeListener() {
        this.graph.getView().getCanvasComponent().removePropertyChangeListener(this);
    }
    
    public void suppressUpdateGraph(final boolean suppressUpdateGraph) {
        this.suppressUpdateGraph = suppressUpdateGraph;
    }
}
