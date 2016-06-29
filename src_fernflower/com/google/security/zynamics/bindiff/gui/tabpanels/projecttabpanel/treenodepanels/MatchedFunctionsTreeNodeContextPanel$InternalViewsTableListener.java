package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.MatchedFunctionsTreeNodeContextPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionsViewsTableModel;

class MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener implements IMatchedFunctionsViewsTableListener {
   // $FF: synthetic field
   final MatchedFunctionsTreeNodeContextPanel this$0;

   private MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(MatchedFunctionsTreeNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void rowSelectionChanged(MatchedFunctionViewsTable var1) {
      MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
   }

   public void tableDataChanged(MatchedFunctionsViewsTableModel var1) {
      MatchedFunctionsTreeNodeContextPanel.access$500(this.this$0, MatchedFunctionsTreeNodeContextPanel.access$400(this.this$0));
      MatchedFunctionsTreeNodeContextPanel.access$600(this.this$0);
   }

   // $FF: synthetic method
   MatchedFunctionsTreeNodeContextPanel$InternalViewsTableListener(MatchedFunctionsTreeNodeContextPanel var1, MatchedFunctionsTreeNodeContextPanel$1 var2) {
      this(var1);
   }
}
