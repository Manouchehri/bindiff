package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.common.base.*;
import java.awt.event.*;

public class OpenFlowGraphsViewAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    private final ZyGraphNode node;
    
    public OpenFlowGraphsViewAction(final ViewTabPanelFunctions viewTabPanelFunctions, final ZyGraphNode zyGraphNode) {
        super("Open Flow Graphs View");
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.node = (ZyGraphNode)Preconditions.checkNotNull(zyGraphNode);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.controller.openFlowgraphsViews(this.node);
    }
}
