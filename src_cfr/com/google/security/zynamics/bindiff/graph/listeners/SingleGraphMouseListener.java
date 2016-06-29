/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.eventhandlers.SingleGraphMouseEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import y.h.aA;

public class SingleGraphMouseListener
implements IZyGraphListener {
    private final SingleGraph graph;
    private final ViewTabPanelFunctions controller;

    protected SingleGraphMouseListener(ViewTabPanelFunctions viewTabPanelFunctions, SingleGraph singleGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (SingleGraph)Preconditions.checkNotNull(singleGraph);
        this.addListener();
    }

    public void addListener() {
        this.graph.addListener(this);
    }

    public void edgeClicked(SingleDiffEdge singleDiffEdge, MouseEvent mouseEvent, double d2, double d3) {
    }

    @Override
    public void edgeLabelEntered(aA aA2, MouseEvent mouseEvent) {
    }

    @Override
    public void edgeLabelExited(aA aA2) {
    }

    public void nodeClicked(SingleDiffNode singleDiffNode, MouseEvent mouseEvent, double d2, double d3) {
        SingleGraphMouseEventHandler.nodeClicked(this.controller, this.graph, singleDiffNode, mouseEvent);
    }

    public void nodeEntered(SingleDiffNode singleDiffNode, MouseEvent mouseEvent) {
        SingleGraphMouseEventHandler.nodeEntered(this.graph, singleDiffNode);
    }

    public void nodeHovered(SingleDiffNode singleDiffNode, double d2, double d3) {
    }

    public void nodeLeft(SingleDiffNode singleDiffNode) {
        SingleGraphMouseEventHandler.nodeLeft(this.graph, singleDiffNode);
    }

    @Override
    public void proximityBrowserNodeClicked(ZyProximityNode zyProximityNode, MouseEvent mouseEvent, double d2, double d3) {
        SingleGraphMouseEventHandler.proximityBrowserNodeClicked(this.graph, zyProximityNode, mouseEvent);
    }

    public void removeListener() {
        this.graph.removeListener(this);
    }
}

