package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsNodeContextPanel$1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class FunctionDiffViewsNodeContextPanel$InternalTableModelListener implements TableModelListener {
   // $FF: synthetic field
   final FunctionDiffViewsNodeContextPanel this$0;

   private FunctionDiffViewsNodeContextPanel$InternalTableModelListener(FunctionDiffViewsNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void tableChanged(TableModelEvent var1) {
      FunctionDiffViewsNodeContextPanel.access$100(this.this$0);
   }

   // $FF: synthetic method
   FunctionDiffViewsNodeContextPanel$InternalTableModelListener(FunctionDiffViewsNodeContextPanel var1, FunctionDiffViewsNodeContextPanel$1 var2) {
      this(var1);
   }
}
