package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.FunctionDiffViewsContainerNodeContextPanel$1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener implements TableModelListener {
   // $FF: synthetic field
   final FunctionDiffViewsContainerNodeContextPanel this$0;

   private FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(FunctionDiffViewsContainerNodeContextPanel var1) {
      this.this$0 = var1;
   }

   public void tableChanged(TableModelEvent var1) {
      FunctionDiffViewsContainerNodeContextPanel.access$100(this.this$0);
   }

   // $FF: synthetic method
   FunctionDiffViewsContainerNodeContextPanel$InternalTableModelListener(FunctionDiffViewsContainerNodeContextPanel var1, FunctionDiffViewsContainerNodeContextPanel$1 var2) {
      this(var1);
   }
}
