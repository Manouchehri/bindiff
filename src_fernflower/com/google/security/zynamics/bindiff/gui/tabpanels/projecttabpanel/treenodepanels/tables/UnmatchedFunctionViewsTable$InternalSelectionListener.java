package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IUnmatchedFunctionsViewsTableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.UnmatchedFunctionViewsTable$1;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class UnmatchedFunctionViewsTable$InternalSelectionListener implements ListSelectionListener {
   // $FF: synthetic field
   final UnmatchedFunctionViewsTable this$0;

   private UnmatchedFunctionViewsTable$InternalSelectionListener(UnmatchedFunctionViewsTable var1) {
      this.this$0 = var1;
   }

   public void valueChanged(ListSelectionEvent var1) {
      Iterator var2 = UnmatchedFunctionViewsTable.access$100(this.this$0).iterator();

      while(var2.hasNext()) {
         IUnmatchedFunctionsViewsTableListener var3 = (IUnmatchedFunctionsViewsTableListener)var2.next();
         var3.rowSelectionChanged(this.this$0);
      }

   }

   // $FF: synthetic method
   UnmatchedFunctionViewsTable$InternalSelectionListener(UnmatchedFunctionViewsTable var1, UnmatchedFunctionViewsTable$1 var2) {
      this(var1);
   }
}
