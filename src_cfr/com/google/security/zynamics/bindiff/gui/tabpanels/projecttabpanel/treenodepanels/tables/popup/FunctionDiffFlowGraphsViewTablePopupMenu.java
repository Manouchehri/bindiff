/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopySelectionToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopyValueToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteFunctionDiffViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenMultipeFlowGraphsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.ViewPopupHelper;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FunctionDiffFlowGraphsViewTablePopupMenu
extends JPopupMenu {
    public FunctionDiffFlowGraphsViewTablePopupMenu(AbstractTable abstractTable, int n2, int n3) {
        this.add(GuiUtils.buildMenuItem("Open Function Diff Views", new OpenMultipeFlowGraphsViewsAction(abstractTable), ViewPopupHelper.isEnabled(abstractTable, n2, true)));
        this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseViewsAction(abstractTable, n2), ViewPopupHelper.isEnabled(abstractTable, n2, false)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Delete Function Diff View", new DeleteFunctionDiffViewAction(abstractTable, n2)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(abstractTable), abstractTable.hasSelection()));
        this.add(GuiUtils.buildMenuItem("Copy Value", new CopyValueToClipboardAction(abstractTable, n2, n3)));
    }
}

