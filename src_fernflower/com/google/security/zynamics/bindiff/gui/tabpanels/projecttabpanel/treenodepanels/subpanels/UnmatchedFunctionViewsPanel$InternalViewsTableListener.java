package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTableModel;

class UnmatchedFunctionViewsPanel$InternalViewsTableListener implements IUnmatchedFunctionsViewsTableListener {
   // $FF: synthetic field
   final UnmatchedFunctionViewsPanel this$0;

   private UnmatchedFunctionViewsPanel$InternalViewsTableListener(UnmatchedFunctionViewsPanel var1) {
      this.this$0 = var1;
   }

   public void rowSelectionChanged(UnmatchedFunctionViewsTable var1) {
   }

   public void tableDataChanged(UnmatchedFunctionViewsTableModel var1) {
      UnmatchedFunctionViewsPanel.access$100(this.this$0);
   }

   // $FF: synthetic method
   UnmatchedFunctionViewsPanel$InternalViewsTableListener(UnmatchedFunctionViewsPanel var1, UnmatchedFunctionViewsPanel$1 var2) {
      this(var1);
   }
}
