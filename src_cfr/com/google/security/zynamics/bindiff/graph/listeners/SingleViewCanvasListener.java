/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.listeners.GraphViewsListenerManager;
import com.google.security.zynamics.bindiff.graph.synchronizer.GraphViewCanvasSynchronizer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import y.h.ch;

public class SingleViewCanvasListener
implements PropertyChangeListener {
    private final SingleGraph graph;
    private final ViewTabPanelFunctions viewPanelController;
    private boolean suppressUpdateGraph = false;

    protected SingleViewCanvasListener(ViewTabPanelFunctions viewTabPanelFunctions, SingleGraph singleGraph) {
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(singleGraph);
        this.viewPanelController = viewTabPanelFunctions;
        this.graph = singleGraph;
        this.addListener();
    }

    public void addListener() {
        this.graph.getView().getCanvasComponent().addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (this.graph.getGraphType() == EGraphType.FLOWGRAPH && this.graph.getFunctionAddress() == null) {
            return;
        }
        if ("Zoom".equals(propertyChangeEvent.getPropertyName())) {
            GraphViewCanvasSynchronizer.adoptZoom(this.viewPanelController.getGraphListenerManager(), this.graph);
            return;
        }
        if (!"ViewPoint".equals(propertyChangeEvent.getPropertyName())) return;
        GraphViewCanvasSynchronizer.adoptViewPoint(this.viewPanelController.getGraphListenerManager(), this.graph, (Point2D.Double)propertyChangeEvent.getOldValue(), this.suppressUpdateGraph);
    }

    public void removeListener() {
        this.graph.getView().getCanvasComponent().removePropertyChangeListener(this);
    }

    public void suppressUpdateGraph(boolean bl2) {
        this.suppressUpdateGraph = bl2;
    }
}

