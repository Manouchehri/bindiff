/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.CallGraphPopupMenu;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.FlowGraphPopupMenu;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Component;
import java.awt.event.MouseEvent;
import y.h.ch;

public final class CombinedGraphMouseEventHandler {
    public static void nodeClicked(ViewTabPanelFunctions viewTabPanelFunctions, CombinedGraph combinedGraph, CombinedDiffNode combinedDiffNode, MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 3) {
            if (combinedDiffNode.getRawNode() instanceof RawCombinedBasicBlock) {
                FlowGraphPopupMenu flowGraphPopupMenu = new FlowGraphPopupMenu(viewTabPanelFunctions, combinedGraph, combinedDiffNode);
                flowGraphPopupMenu.show(combinedGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            } else if (combinedDiffNode.getRawNode() instanceof RawCombinedFunction) {
                CallGraphPopupMenu callGraphPopupMenu = new CallGraphPopupMenu(viewTabPanelFunctions, combinedGraph, combinedDiffNode);
                callGraphPopupMenu.show(combinedGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            }
        }
        if (mouseEvent.getButton() != 1) return;
        if (mouseEvent.getClickCount() != 2) return;
        if (combinedGraph.getGraphType() != EGraphType.CALLGRAPH) return;
        viewTabPanelFunctions.openFlowgraphsViews(combinedDiffNode);
    }

    public static void proximityBrowserNodeClicked(CombinedGraph combinedGraph, ZyProximityNode zyProximityNode, MouseEvent mouseEvent) {
        if (mouseEvent.getButton() != 1) return;
        GraphLayoutEventHandler.handleProximityNodeClickedEvent(combinedGraph, zyProximityNode);
    }
}

