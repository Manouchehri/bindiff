package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.AbstractAction;

public class CloseViewsAction extends AbstractAction {
   private final WorkspaceTabPanelFunctions controller;
   private final AbstractTable table;

   public CloseViewsAction(AbstractTable var1, int var2) {
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
      this.controller = var1.getController();
   }

   public CloseViewsAction(WorkspaceTabPanelFunctions var1) {
      this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.table = null;
   }

   public void actionPerformed(ActionEvent var1) {
      if(this.table == null) {
         Diff var2 = this.controller.getSelectedDiff();
         HashSet var3 = new HashSet();
         if(var2 != null) {
            var3.add(var2);
         }

         this.controller.closeViews(this.controller.getOpenViews(var3));
      } else {
         HashSet var12 = new HashSet();
         Diff var13 = this.table.getDiff();
         boolean var4 = var13 == null;
         int[] var5 = this.table.getSelectedRows();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            int var8 = var5[var7];
            if(var4) {
               var13 = AbstractTable.getRowDiff(this.table, var8);
            }

            Pair var9 = AbstractTable.getViewAddressPair(this.table, var8);
            if(var9 != null) {
               TabPanelManager var10 = this.controller.getMainWindow().getController().getTabPanelManager();
               ViewTabPanel var11 = var10.getTabPanel((IAddress)var9.first(), (IAddress)var9.second(), var13);
               if(var11 != null) {
                  var12.add(var11);
               }
            }
         }

         this.controller.closeViews(var12);
      }

   }
}
