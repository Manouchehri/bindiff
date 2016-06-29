/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.eventhandlers.CombinedGraphMouseEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import y.h.aA;

public class CombinedGraphMouseListener
implements IZyGraphListener {
    private final CombinedGraph graph;
    private final ViewTabPanelFunctions controller;

    protected CombinedGraphMouseListener(ViewTabPanelFunctions viewTabPanelFunctions, CombinedGraph combinedGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (CombinedGraph)Preconditions.checkNotNull(combinedGraph);
        this.addListener();
    }

    public void addListener() {
        this.graph.addListener(this);
    }

    public void edgeClicked(CombinedDiffEdge combinedDiffEdge, MouseEvent mouseEvent, double d2, double d3) {
    }

    @Override
    public void edgeLabelEntered(aA aA2, MouseEvent mouseEvent) {
    }

    @Override
    public void edgeLabelExited(aA aA2) {
    }

    public void nodeClicked(CombinedDiffNode combinedDiffNode, MouseEvent mouseEvent, double d2, double d3) {
        CombinedGraphMouseEventHandler.nodeClicked(this.controller, this.graph, combinedDiffNode, mouseEvent);
    }

    public void nodeEntered(CombinedDiffNode combinedDiffNode, MouseEvent mouseEvent) {
    }

    public void nodeHovered(CombinedDiffNode combinedDiffNode, double d2, double d3) {
    }

    public void nodeLeft(CombinedDiffNode combinedDiffNode) {
    }

    @Override
    public void proximityBrowserNodeClicked(ZyProximityNode zyProximityNode, MouseEvent mouseEvent, double d2, double d3) {
        CombinedGraphMouseEventHandler.proximityBrowserNodeClicked(this.graph, zyProximityNode, mouseEvent);
    }

    public void removeListener() {
        this.graph.removeListener(this);
    }
}

