package com.google.security.zynamics.bindiff.graph.eventhandlers;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.popupmenus.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.synchronizer.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;

public final class SingleGraphMouseEventHandler
{
    public static void nodeClicked(final ViewTabPanelFunctions viewTabPanelFunctions, final SingleGraph singleGraph, final SingleDiffNode singleDiffNode, final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 3) {
            if (singleDiffNode.getRawNode() instanceof RawFunction) {
                new CallGraphPopupMenu(viewTabPanelFunctions, singleGraph, singleDiffNode).show(singleGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            }
            else if (singleDiffNode.getRawNode() instanceof RawBasicBlock) {
                new FlowGraphPopupMenu(viewTabPanelFunctions, singleGraph, singleDiffNode).show(singleGraph.getView(), mouseEvent.getX(), mouseEvent.getY());
            }
        }
        if (mouseEvent.getButton() == 1 && mouseEvent.getClickCount() == 2 && singleGraph.getGraphType() == EGraphType.CALLGRAPH) {
            viewTabPanelFunctions.openFlowgraphsViews(singleDiffNode);
        }
    }
    
    public static void nodeEntered(final SingleGraph singleGraph, final SingleDiffNode singleDiffNode) {
        if (singleDiffNode != null) {
            GraphMouseHoverSynchronizer.adoptHoveredNodeState(singleGraph, singleDiffNode);
        }
    }
    
    public static void nodeLeft(final SingleGraph singleGraph, final SingleDiffNode singleDiffNode) {
        if (singleDiffNode != null) {
            GraphMouseHoverSynchronizer.adoptHoveredNodeState(singleGraph, singleDiffNode);
        }
    }
    
    public static void proximityBrowserNodeClicked(final SingleGraph singleGraph, final ZyProximityNode zyProximityNode, final MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == 1) {
            GraphLayoutEventHandler.handleProximityNodeClickedEvent(singleGraph, zyProximityNode);
        }
    }
}
