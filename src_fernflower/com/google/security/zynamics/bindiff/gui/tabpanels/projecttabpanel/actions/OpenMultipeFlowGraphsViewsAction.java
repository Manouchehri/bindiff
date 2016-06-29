package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import javax.swing.AbstractAction;

public class OpenMultipeFlowGraphsViewsAction extends AbstractAction {
   private static int OPEN_VIEWS_WARNING_THRESHOLD = 10;
   private final AbstractTable table;

   public OpenMultipeFlowGraphsViewsAction(AbstractTable var1) {
      this.table = (AbstractTable)Preconditions.checkNotNull(var1);
   }

   public void actionPerformed(ActionEvent var1) {
      WorkspaceTabPanelFunctions var2 = this.table.getController();
      LinkedHashSet var3 = new LinkedHashSet();
      int[] var4 = this.table.getSelectedRows();
      LinkedHashSet var5 = new LinkedHashSet();

      int var6;
      int var7;
      Diff var8;
      for(var6 = 0; var6 < var4.length; ++var6) {
         var7 = var4[var6];
         var8 = AbstractTable.getRowDiff(this.table, var7);
         if(!var8.isLoaded()) {
            var5.add(var8);
         }
      }

      var2.loadFunctionDiffs(var5);

      for(var6 = 0; var6 < var4.length; ++var6) {
         var7 = var4[var6];
         var8 = AbstractTable.getRowDiff(this.table, var7);
         Pair var9 = AbstractTable.getViewAddressPair(this.table, var7);
         var3.add(Triple.make(var8, var9.first(), var9.second()));
      }

      var6 = 0;
      if(var3.size() > OPEN_VIEWS_WARNING_THRESHOLD) {
         var6 = CMessageBox.showYesNoQuestion(var2.getMainWindow(), String.format("This operation will open more than %d views. Continue?", new Object[]{Integer.valueOf(OPEN_VIEWS_WARNING_THRESHOLD)}));
      }

      if(var6 == 0) {
         var2.openFlowgraphViews(var2.getMainWindow(), var3);
      }

   }
}
