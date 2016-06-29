package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopySelectionToClipboardAction extends AbstractAction {
   private final AbstractTable table;

   public CopySelectionToClipboardAction(AbstractTable var1) {
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      StringBuilder var2 = new StringBuilder();
      CTableSorter var3 = this.table.getModel();
      int[] var4 = this.table.getSelectedRows();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = var4[var6];

         for(int var8 = 0; var8 < var3.getColumnCount(); ++var8) {
            if(var8 > 0) {
               var2.append("\t");
            }

            Object var9 = this.table.getModel().getValueAt(var7, var8);
            if(var9 == ExtendedMatchedFunctionViewsTableModel.ADDED_ICON) {
               var2.append("+");
            } else if(var9 == ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON) {
               var2.append("-");
            } else {
               var2.append(var9.toString());
            }
         }

         var2.append("\n");
      }

      ClipboardHelpers.copyToClipboard(var2.toString());
   }
}
