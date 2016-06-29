package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopySelectionToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CopyValueToClipboardAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.OpenMultipeFlowGraphsViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.ShowInCallGraphAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.popup.ViewPopupHelper;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu.Separator;

public class FlowGraphViewsTablePopupMenu extends JPopupMenu {
   public FlowGraphViewsTablePopupMenu(AbstractTable var1, int var2, int var3) {
      this.add(GuiUtils.buildMenuItem("Open Flow Graph", new OpenMultipeFlowGraphsViewsAction(var1), ViewPopupHelper.isEnabled(var1, var2, true)));
      this.add(GuiUtils.buildMenuItem("Close Flow Graph", new CloseViewsAction(var1, var2), ViewPopupHelper.isEnabled(var1, var2, false)));
      this.add(new JSeparator());
      this.add(GuiUtils.buildMenuItem("Show in Call Graph", new ShowInCallGraphAction(var1)));
      this.add(new Separator());
      this.add(GuiUtils.buildMenuItem("Copy Selection", new CopySelectionToClipboardAction(var1), var1.hasSelection()));
      this.add(GuiUtils.buildMenuItem("Copy Cell Value", new CopyValueToClipboardAction(var1, var2, var3)));
   }
}
