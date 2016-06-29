/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class OpenFlowGraphsViewAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;
    private final ZyGraphNode node;

    public OpenFlowGraphsViewAction(ViewTabPanelFunctions viewTabPanelFunctions, ZyGraphNode zyGraphNode) {
        super("Open Flow Graphs View");
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.node = (ZyGraphNode)Preconditions.checkNotNull(zyGraphNode);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.openFlowgraphsViews(this.node);
    }
}

