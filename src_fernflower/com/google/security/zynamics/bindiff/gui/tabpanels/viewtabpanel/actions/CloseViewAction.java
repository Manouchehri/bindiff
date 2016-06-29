package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import javax.swing.AbstractAction;
import javax.swing.JTabbedPane;

public class CloseViewAction extends AbstractAction {
   private final ViewTabPanelFunctions controller;
   private ViewTabPanel viewPanel;

   public CloseViewAction(ViewTabPanel var1) {
      this.controller = null;
      this.viewPanel = (ViewTabPanel)Preconditions.checkNotNull(var1);
   }

   public CloseViewAction(ViewTabPanelFunctions var1) {
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.viewPanel = null;
   }

   public void actionPerformed(ActionEvent var1) {
      this.execute();
   }

   public void execute() {
      if(this.controller != null) {
         JTabbedPane var1 = this.controller.getTabPanelManager().getTabbedPane();
         this.viewPanel = var1.getSelectedIndex() > 0?(ViewTabPanel)var1.getSelectedComponent():null;
      }

      if(this.viewPanel != null) {
         TabPanelManager var4 = this.viewPanel.getController().getTabPanelManager();
         WorkspaceTabPanelFunctions var2 = var4.getWorkspaceTabPanel().getController();
         LinkedHashSet var3 = new LinkedHashSet();
         var3.add(this.viewPanel);
         var2.closeViews(var3);
      }

   }
}
