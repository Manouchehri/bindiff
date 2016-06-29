package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseCallGraphViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopySelectionToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopyValueToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenCallGraphViewAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.ViewPopupHelper;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

public class CallGraphViewsPopupMenu extends JPopupMenu {
   public CallGraphViewsPopupMenu(AbstractTable var1, int var2) {
      WorkspaceTabPanelFunctions var3 = var1.getController();
      this.add(GuiUtils.buildMenuItem("Open Call Graph", new OpenCallGraphViewAction(var3, var1.getDiff()), ViewPopupHelper.isEnabled(var1, 0, true)));
      this.add(GuiUtils.buildMenuItem("Close Call Graph", new CloseCallGraphViewAction(var3, var1.getDiff()), ViewPopupHelper.isEnabled(var1, 0, false)));
      this.add(new JSeparator());
      this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(var1), var1.hasSelection()));
      this.add(GuiUtils.buildMenuItem("Copy Value", new CopyValueToClipboardAction(var1, 0, var2)));
   }
}
