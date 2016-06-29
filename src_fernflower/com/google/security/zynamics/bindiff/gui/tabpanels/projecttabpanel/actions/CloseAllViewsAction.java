package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.LinkedHashSet;
import javax.swing.AbstractAction;

public class CloseAllViewsAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;
   private final ViewTabPanel dontClosePanel;

   public CloseAllViewsAction(WorkspaceTabPanelFunctions var1) {
      this(var1, (ViewTabPanel)null);
   }

   public CloseAllViewsAction(WorkspaceTabPanelFunctions var1, ViewTabPanel var2) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.dontClosePanel = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      LinkedHashSet var2 = new LinkedHashSet();
      TabPanelManager var3 = this.controller.getMainWindow().getController().getTabPanelManager();
      Iterator var4 = var3.getViewTabPanels().iterator();

      while(true) {
         ViewTabPanel var5;
         do {
            if(!var4.hasNext()) {
               this.controller.closeViews(var2);
               return;
            }

            var5 = (ViewTabPanel)var4.next();
         } while(this.dontClosePanel != null && this.dontClosePanel == var5);

         var2.add(var5);
      }
   }
}
