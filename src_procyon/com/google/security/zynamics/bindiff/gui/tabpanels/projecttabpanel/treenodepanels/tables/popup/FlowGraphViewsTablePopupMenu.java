package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;

public class FlowGraphViewsTablePopupMenu extends JPopupMenu
{
    public FlowGraphViewsTablePopupMenu(final AbstractTable abstractTable, final int n, final int n2) {
        this.add(GuiUtils.buildMenuItem("Open Flow Graph", new OpenMultipeFlowGraphsViewsAction(abstractTable), ViewPopupHelper.isEnabled(abstractTable, n, true)));
        this.add(GuiUtils.buildMenuItem("Close Flow Graph", new CloseViewsAction(abstractTable, n), ViewPopupHelper.isEnabled(abstractTable, n, false)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Show in Call Graph", new ShowInCallGraphAction(abstractTable)));
        this.add(new Separator());
        this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(abstractTable), abstractTable.hasSelection()));
        this.add(GuiUtils.buildMenuItem("Copy Cell Value", new CopyValueToClipboardAction(abstractTable, n, n2)));
    }
}
