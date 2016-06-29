package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.AbstractAction;

public class CloseDiffAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;

   public CloseDiffAction(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      HashSet var2 = new HashSet();
      var2.add(this.controller.getSelectedDiff());
      this.controller.closeDiffs(var2);
   }
}
