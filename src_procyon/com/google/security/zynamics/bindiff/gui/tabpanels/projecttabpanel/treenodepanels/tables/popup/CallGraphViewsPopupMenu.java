package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;

public class CallGraphViewsPopupMenu extends JPopupMenu
{
    public CallGraphViewsPopupMenu(final AbstractTable abstractTable, final int n) {
        final WorkspaceTabPanelFunctions controller = abstractTable.getController();
        this.add(GuiUtils.buildMenuItem("Open Call Graph", new OpenCallGraphViewAction(controller, abstractTable.getDiff()), ViewPopupHelper.isEnabled(abstractTable, 0, true)));
        this.add(GuiUtils.buildMenuItem("Close Call Graph", new CloseCallGraphViewAction(controller, abstractTable.getDiff()), ViewPopupHelper.isEnabled(abstractTable, 0, false)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(abstractTable), abstractTable.hasSelection()));
        this.add(GuiUtils.buildMenuItem("Copy Value", new CopyValueToClipboardAction(abstractTable, 0, n)));
    }
}
