package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.common.base.*;
import java.awt.event.*;

public class PrintViewAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    private final BinDiffGraph graph;
    
    public PrintViewAction(final ViewTabPanelFunctions viewTabPanelFunctions, final BinDiffGraph binDiffGraph) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.controller.printView(this.graph);
    }
}
