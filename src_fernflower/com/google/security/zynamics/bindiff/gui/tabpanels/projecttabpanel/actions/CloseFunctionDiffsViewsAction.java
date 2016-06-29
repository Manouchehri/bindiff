package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.FunctionDiffViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.AbstractAction;

public class CloseFunctionDiffsViewsAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;
   private final FunctionDiffViewsTable table;

   public CloseFunctionDiffsViewsAction(FunctionDiffViewsTable var1) {
      this.table = (FunctionDiffViewsTable)Preconditions.checkNotNull(var1);
      this.controller = var1.getController();
   }

   public CloseFunctionDiffsViewsAction(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.table = null;
   }

   public void actionPerformed(ActionEvent var1) {
      TabPanelManager var2 = this.controller.getMainWindow().getController().getTabPanelManager();
      HashSet var3 = new HashSet();
      if(this.table == null) {
         var3.addAll(var2.getViewTabPanels(true));
      } else {
         for(int var4 = 0; var4 < this.table.getRowCount(); ++var4) {
            Diff var5 = AbstractTable.getRowDiff(this.table, var4);
            Iterator var6 = var2.getViewTabPanels(true).iterator();

            while(var6.hasNext()) {
               ViewTabPanel var7 = (ViewTabPanel)var6.next();
               if(var7.getDiff() == var5) {
                  var3.add(var7);
                  break;
               }
            }
         }
      }

      this.controller.closeViews(var3);
   }
}
