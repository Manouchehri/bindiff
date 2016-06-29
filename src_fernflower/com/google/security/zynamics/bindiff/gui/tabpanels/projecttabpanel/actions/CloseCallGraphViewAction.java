package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.AbstractAction;

public class CloseCallGraphViewAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;
   private final Diff diff;

   public CloseCallGraphViewAction(WorkspaceTabPanelFunctions var1, Diff var2) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.diff = (Diff)Preconditions.checkNotNull(var2);
   }

   public void actionPerformed(ActionEvent var1) {
      TabPanelManager var2 = this.controller.getMainWindow().getController().getTabPanelManager();
      ViewTabPanel var3 = var2.getTabPanel((IAddress)null, (IAddress)null, this.diff);
      if(var3 != null) {
         HashSet var4 = new HashSet();
         var4.add(var3);
         this.controller.closeViews(var4);
      }

   }
}
