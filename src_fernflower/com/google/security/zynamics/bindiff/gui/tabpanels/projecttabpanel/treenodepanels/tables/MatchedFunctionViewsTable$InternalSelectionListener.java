package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IMatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.MatchedFunctionViewsTable$1;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MatchedFunctionViewsTable$InternalSelectionListener implements ListSelectionListener {
   // $FF: synthetic field
   final MatchedFunctionViewsTable this$0;

   private MatchedFunctionViewsTable$InternalSelectionListener(MatchedFunctionViewsTable var1) {
      this.this$0 = var1;
   }

   public void valueChanged(ListSelectionEvent var1) {
      Iterator var2 = MatchedFunctionViewsTable.access$100(this.this$0).iterator();

      while(var2.hasNext()) {
         IMatchedFunctionsViewsTableListener var3 = (IMatchedFunctionsViewsTableListener)var2.next();
         var3.rowSelectionChanged(this.this$0);
      }

   }

   // $FF: synthetic method
   MatchedFunctionViewsTable$InternalSelectionListener(MatchedFunctionViewsTable var1, MatchedFunctionViewsTable$1 var2) {
      this(var1);
   }
}
