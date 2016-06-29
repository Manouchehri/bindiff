/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.synchronizer.GraphMouseHoverSynchronizer;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Component;
import java.awt.event.MouseEvent;
import y.h.ch;

public final class SingleGraphMouseEventHandler {
    public static void nodeClicked(ViewTabPanelFunctions viewTabPanelFunctions, SingleGraph singleGraph, SingleDiffNode singleDiffNode, MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 3) {
            if (singleDiffNode.getRawNode() instanceof RawFunction) {
                CallGraphPopupMenu callGraphPopupMenu = new CallGraphPopupMenu(viewTabPanelFunctions, singleGraph, singleDiffNode);
                callGraphPopupMenu.show(singleGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            } else if (singleDiffNode.getRawNode() instanceof RawBasicBlock) {
                FlowGraphPopupMenu flowGraphPopupMenu = new FlowGraphPopupMenu(viewTabPanelFunctions, singleGraph, singleDiffNode);
                flowGraphPopupMenu.show(singleGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            }
        }
        if (mouseEvent.getButton() != 1) return;
        if (mouseEvent.getClickCount() != 2) return;
        if (singleGraph.getGraphType() != EGraphType.CALLGRAPH) return;
        viewTabPanelFunctions.openFlowgraphsViews(singleDiffNode);
    }

    public static void nodeEntered(SingleGraph singleGraph, SingleDiffNode singleDiffNode) {
        if (singleDiffNode == null) return;
        GraphMouseHoverSynchronizer.adoptHoveredNodeState(singleGraph, singleDiffNode);
    }

    public static void nodeLeft(SingleGraph singleGraph, SingleDiffNode singleDiffNode) {
        if (singleDiffNode == null) return;
        GraphMouseHoverSynchronizer.adoptHoveredNodeState(singleGraph, singleDiffNode);
    }

    public static void proximityBrowserNodeClicked(SingleGraph singleGraph, ZyProximityNode zyProximityNode, MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 1) return;
        GraphLayoutEventHandler.handleProximityNodeClickedEvent(singleGraph, zyProximityNode);
    }
}

