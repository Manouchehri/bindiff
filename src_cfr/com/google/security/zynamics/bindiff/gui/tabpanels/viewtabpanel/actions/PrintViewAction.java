/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class PrintViewAction
extends AbstractAction {
    private final ViewTabPanelFunctions controller;
    private final BinDiffGraph graph;

    public PrintViewAction(ViewTabPanelFunctions viewTabPanelFunctions, BinDiffGraph binDiffGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.controller.printView(this.graph);
    }
}

