package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.AbstractTable$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.IViewsTableListener;
import java.util.Iterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class AbstractTable$InternalSelectionListener implements ListSelectionListener {
   // $FF: synthetic field
   final AbstractTable this$0;

   private AbstractTable$InternalSelectionListener(AbstractTable var1) {
      this.this$0 = var1;
   }

   public void valueChanged(ListSelectionEvent var1) {
      Iterator var2 = AbstractTable.access$400(this.this$0).iterator();

      while(var2.hasNext()) {
         IViewsTableListener var3 = (IViewsTableListener)var2.next();
         var3.rowSelectionChanged(this.this$0);
      }

   }

   // $FF: synthetic method
   AbstractTable$InternalSelectionListener(AbstractTable var1, AbstractTable$1 var2) {
      this(var1);
   }
}
