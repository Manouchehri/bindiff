package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;

public final class CombinedGraphMouseEventHandler
{
    public static void nodeClicked(final ViewTabPanelFunctions viewTabPanelFunctions, final CombinedGraph combinedGraph, final CombinedDiffNode combinedDiffNode, final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 3) {
            if (combinedDiffNode.getRawNode() instanceof RawCombinedBasicBlock) {
                new FlowGraphPopupMenu(viewTabPanelFunctions, combinedGraph, combinedDiffNode).show(combinedGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            }
            else if (combinedDiffNode.getRawNode() instanceof RawCombinedFunction) {
                new CallGraphPopupMenu(viewTabPanelFunctions, combinedGraph, combinedDiffNode).show(combinedGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            }
        }
        if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 2 && combinedGraph.getGraphType() == EGraphType.CALLGRAPH) {
            viewTabPanelFunctions.openFlowgraphsViews(combinedDiffNode);
        }
    }
    
    public static void proximityBrowserNodeClicked(final CombinedGraph combinedGraph, final ZyProximityNode zyProximityNode, final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1) {
            GraphLayoutEventHandler.handleProximityNodeClickedEvent(combinedGraph, zyProximityNode);
        }
    }
}
