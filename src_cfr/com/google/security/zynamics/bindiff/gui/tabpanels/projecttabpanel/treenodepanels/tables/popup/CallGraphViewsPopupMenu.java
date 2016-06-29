/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseCallGraphViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopySelectionToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopyValueToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenCallGraphViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.ViewPopupHelper;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class CallGraphViewsPopupMenu
extends JPopupMenu {
    public CallGraphViewsPopupMenu(AbstractTable abstractTable, int n2) {
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = abstractTable.getController();
        this.add(GuiUtils.buildMenuItem("Open Call Graph", new OpenCallGraphViewAction(workspaceTabPanelFunctions, abstractTable.getDiff()), ViewPopupHelper.isEnabled(abstractTable, 0, true)));
        this.add(GuiUtils.buildMenuItem("Close Call Graph", new CloseCallGraphViewAction(workspaceTabPanelFunctions, abstractTable.getDiff()), ViewPopupHelper.isEnabled(abstractTable, 0, false)));
        this.add(new JSeparator());
        this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(abstractTable), abstractTable.hasSelection()));
        this.add(GuiUtils.buildMenuItem("Copy Value", new CopyValueToClipboardAction(abstractTable, 0, n2)));
    }
}

