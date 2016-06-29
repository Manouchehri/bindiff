package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import java.awt.event.*;
import y.h.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;

public class CombinedGraphMouseListener implements IZyGraphListener
{
    private final CombinedGraph graph;
    private final ViewTabPanelFunctions controller;
    
    protected CombinedGraphMouseListener(final ViewTabPanelFunctions viewTabPanelFunctions, final CombinedGraph combinedGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (CombinedGraph)Preconditions.checkNotNull(combinedGraph);
        this.addListener();
    }
    
    public void addListener() {
        this.graph.addListener(this);
    }
    
    public void edgeClicked(final CombinedDiffEdge combinedDiffEdge, final MouseEvent mouseEvent, final double n, final double n2) {
    }
    
    @Override
    public void edgeLabelEntered(final aA aa, final MouseEvent mouseEvent) {
    }
    
    @Override
    public void edgeLabelExited(final aA aa) {
    }
    
    public void nodeClicked(final CombinedDiffNode combinedDiffNode, final MouseEvent mouseEvent, final double n, final double n2) {
        CombinedGraphMouseEventHandler.nodeClicked(this.controller, this.graph, combinedDiffNode, mouseEvent);
    }
    
    public void nodeEntered(final CombinedDiffNode combinedDiffNode, final MouseEvent mouseEvent) {
    }
    
    public void nodeHovered(final CombinedDiffNode combinedDiffNode, final double n, final double n2) {
    }
    
    public void nodeLeft(final CombinedDiffNode combinedDiffNode) {
    }
    
    @Override
    public void proximityBrowserNodeClicked(final ZyProximityNode zyProximityNode, final MouseEvent mouseEvent, final double n, final double n2) {
        CombinedGraphMouseEventHandler.proximityBrowserNodeClicked(this.graph, zyProximityNode, mouseEvent);
    }
    
    public void removeListener() {
        this.graph.removeListener(this);
    }
}
