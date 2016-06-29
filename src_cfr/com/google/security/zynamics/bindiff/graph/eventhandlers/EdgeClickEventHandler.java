/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphMover;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.MouseEvent;
import y.c.d;
import y.h.bu;
import y.h.ch;

public class EdgeClickEventHandler {
    public static void handleEdgeClicks(AbstractZyGraph abstractZyGraph, ZyGraphEdge zyGraphEdge, MouseEvent mouseEvent) {
        Preconditions.checkNotNull(abstractZyGraph, "Graph argument can not be null");
        Preconditions.checkNotNull(zyGraphEdge, "Edge argument can not be null");
        Preconditions.checkNotNull(mouseEvent, "Event argument can not be null");
        if (mouseEvent.getButton() == 1 && mouseEvent.isShiftDown()) {
            abstractZyGraph.getGraph().a(zyGraphEdge.getEdge(), !zyGraphEdge.isSelected());
            return;
        }
        if (mouseEvent.getButton() != 1) return;
        if (mouseEvent.isShiftDown()) return;
        if (zyGraphEdge.getSource() == zyGraphEdge.getTarget()) return;
        double d2 = abstractZyGraph.getView().toWorldCoordX(mouseEvent.getX());
        double d3 = abstractZyGraph.getView().toWorldCoordY(mouseEvent.getY());
        GraphMover.moveToEdgeNode((BinDiffGraph)abstractZyGraph, zyGraphEdge.getEdge(), d2, d3);
    }
}

