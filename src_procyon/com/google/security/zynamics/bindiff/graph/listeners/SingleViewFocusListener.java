package com.google.security.zynamics.bindiff.graph.listeners;

import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;

public class SingleViewFocusListener extends MouseAdapter
{
    private final SingleGraph graph;
    private final ViewTabPanelFunctions controller;
    
    protected SingleViewFocusListener(final ViewTabPanelFunctions viewTabPanelFunctions, final SingleGraph singleGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (SingleGraph)Preconditions.checkNotNull(singleGraph);
        this.addListener();
    }
    
    public void addListener() {
        this.graph.getView().getCanvasComponent().addMouseListener(this);
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.controller.setViewFocus(this.graph.getSide());
    }
    
    public void removeListener() {
        this.graph.getView().getCanvasComponent().removeMouseListener(this);
    }
}
