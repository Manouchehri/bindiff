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

public class SingleGraphMouseListener implements IZyGraphListener
{
    private final SingleGraph graph;
    private final ViewTabPanelFunctions controller;
    
    protected SingleGraphMouseListener(final ViewTabPanelFunctions viewTabPanelFunctions, final SingleGraph singleGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (SingleGraph)Preconditions.checkNotNull(singleGraph);
        this.addListener();
    }
    
    public void addListener() {
        this.graph.addListener(this);
    }
    
    public void edgeClicked(final SingleDiffEdge singleDiffEdge, final MouseEvent mouseEvent, final double n, final double n2) {
    }
    
    @Override
    public void edgeLabelEntered(final aA aa, final MouseEvent mouseEvent) {
    }
    
    @Override
    public void edgeLabelExited(final aA aa) {
    }
    
    public void nodeClicked(final SingleDiffNode singleDiffNode, final MouseEvent mouseEvent, final double n, final double n2) {
        SingleGraphMouseEventHandler.nodeClicked(this.controller, this.graph, singleDiffNode, mouseEvent);
    }
    
    public void nodeEntered(final SingleDiffNode singleDiffNode, final MouseEvent mouseEvent) {
        SingleGraphMouseEventHandler.nodeEntered(this.graph, singleDiffNode);
    }
    
    public void nodeHovered(final SingleDiffNode singleDiffNode, final double n, final double n2) {
    }
    
    public void nodeLeft(final SingleDiffNode singleDiffNode) {
        SingleGraphMouseEventHandler.nodeLeft(this.graph, singleDiffNode);
    }
    
    @Override
    public void proximityBrowserNodeClicked(final ZyProximityNode zyProximityNode, final MouseEvent mouseEvent, final double n, final double n2) {
        SingleGraphMouseEventHandler.proximityBrowserNodeClicked(this.graph, zyProximityNode, mouseEvent);
    }
    
    public void removeListener() {
        this.graph.removeListener(this);
    }
}
