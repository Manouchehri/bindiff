package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.ExtendedMatchedFunctionViewsTableModel;
import com.google.security.zynamics.zylib.general.ClipboardHelpers;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class CopyValueToClipboardAction extends AbstractAction {
   private final AbstractTable table;
   private final int hitRowIndex;
   private final int hitColumnIndex;

   public CopyValueToClipboardAction(AbstractTable var1, int var2, int var3) {
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
      this.hitRowIndex = var2;
      this.hitColumnIndex = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = "";
      Object var3 = this.table.getModel().getValueAt(this.hitRowIndex, this.hitColumnIndex);
      if(var3 == ExtendedMatchedFunctionViewsTableModel.ADDED_ICON) {
         var2 = "+";
      } else if(var3 == ExtendedMatchedFunctionViewsTableModel.REMOVED_ICON) {
         var2 = "-";
      } else {
         var2 = this.table.getModel().getValueAt(this.hitRowIndex, this.hitColumnIndex).toString();
      }

      ClipboardHelpers.copyToClipboard(var2);
   }
}
