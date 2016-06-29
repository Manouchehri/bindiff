package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;

public class FunctionDiffFlowGraphsViewTablePopupMenu extends JPopupMenu
{
    public FunctionDiffFlowGraphsViewTablePopupMenu(final AbstractTable abstractTable, final int n, final int n2) {
        this.add(GuiUtils.buildMenuItem("Open Function Diff Views", new OpenMultipeFlowGraphsViewsAction(abstractTable), ViewPopupHelper.isEnabled(abstractTable, n, true)));
        this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseViewsAction(abstractTable, n), ViewPopupHelper.isEnabled(abstractTable, n, false)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Delete Function Diff View", new DeleteFunctionDiffViewAction(abstractTable, n)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(abstractTable), abstractTable.hasSelection()));
        this.add(GuiUtils.buildMenuItem("Copy Value", new CopyValueToClipboardAction(abstractTable, n, n2)));
    }
}
