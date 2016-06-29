package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class OpenCallGraphViewAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;
   private final Diff diff;

   public OpenCallGraphViewAction(WorkspaceTabPanelFunctions var1, Diff var2) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.diff = (Diff)Preconditions.checkNotNull(var2);
   }

   public void actionPerformed(ActionEvent var1) {
      this.controller.openCallgraphView(this.controller.getMainWindow(), this.diff);
   }
}
