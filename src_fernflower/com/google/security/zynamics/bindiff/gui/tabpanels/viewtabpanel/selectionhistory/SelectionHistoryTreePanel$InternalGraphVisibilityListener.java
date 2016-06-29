package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel$1;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;

class SelectionHistoryTreePanel$InternalGraphVisibilityListener implements IZyGraphVisibilityListener {
   // $FF: synthetic field
   final SelectionHistoryTreePanel this$0;

   private SelectionHistoryTreePanel$InternalGraphVisibilityListener(SelectionHistoryTreePanel var1) {
      this.this$0 = var1;
   }

   public void nodeDeleted() {
      this.this$0.updateUI();
   }

   public void visibilityChanged() {
      this.this$0.updateUI();
   }

   // $FF: synthetic method
   SelectionHistoryTreePanel$InternalGraphVisibilityListener(SelectionHistoryTreePanel var1, SelectionHistoryTreePanel$1 var2) {
      this(var1);
   }
}
