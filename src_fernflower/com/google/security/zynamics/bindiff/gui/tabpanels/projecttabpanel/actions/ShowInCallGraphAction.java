package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import javax.swing.AbstractAction;

public class ShowInCallGraphAction extends AbstractAction {
   private final AbstractTable table;

   public ShowInCallGraphAction(AbstractTable var1) {
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      HashSet var2 = new HashSet();
      int[] var3 = this.table.getSelectedRows();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         int var6 = var3[var5];
         var2.add(AbstractTable.getViewAddressPair(this.table, var6));
      }

      Diff var7 = this.table.getDiff();
      this.table.getController().showInCallgraph(var7, var2);
   }
}
