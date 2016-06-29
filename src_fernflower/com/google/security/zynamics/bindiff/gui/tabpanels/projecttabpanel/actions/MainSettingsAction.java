package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class MainSettingsAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;

   public MainSettingsAction(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      this.controller.showMainSettingsDialog();
   }
}
