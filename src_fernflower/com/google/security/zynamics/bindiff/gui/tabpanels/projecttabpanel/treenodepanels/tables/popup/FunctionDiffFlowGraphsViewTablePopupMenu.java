package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopySelectionToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopyValueToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.DeleteFunctionDiffViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenMultipeFlowGraphsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.ViewPopupHelper;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class FunctionDiffFlowGraphsViewTablePopupMenu extends JPopupMenu {
   public FunctionDiffFlowGraphsViewTablePopupMenu(AbstractTable var1, int var2, int var3) {
      this.add(GuiUtils.buildMenuItem("Open Function Diff Views", new OpenMultipeFlowGraphsViewsAction(var1), ViewPopupHelper.isEnabled(var1, var2, true)));
      this.add(GuiUtils.buildMenuItem("Close Function Diff Views", new CloseViewsAction(var1, var2), ViewPopupHelper.isEnabled(var1, var2, false)));
      this.add(new JSeparator());
      this.add(GuiUtils.buildMenuItem("Delete Function Diff View", new DeleteFunctionDiffViewAction(var1, var2)));
      this.add(new JSeparator());
      this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(var1), var1.hasSelection()));
      this.add(GuiUtils.buildMenuItem("Copy Value", new CopyValueToClipboardAction(var1, var2, var3)));
   }
}
