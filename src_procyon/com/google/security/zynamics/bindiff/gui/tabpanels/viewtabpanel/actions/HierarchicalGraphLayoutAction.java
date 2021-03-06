package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.enums.*;

public class HierarchicalGraphLayoutAction extends AbstractAction
{
    private final ViewTabPanelFunctions controller;
    
    public HierarchicalGraphLayoutAction(final ViewTabPanelFunctions viewTabPanelFunctions) {
        this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(viewTabPanelFunctions);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.controller.doLayout(EGraphLayout.HIERARCHICAL);
    }
}
