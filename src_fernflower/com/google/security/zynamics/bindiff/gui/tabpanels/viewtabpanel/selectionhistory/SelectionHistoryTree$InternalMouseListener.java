package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTree$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SelectionHistoryTree$InternalMouseListener extends MouseAdapter {
   // $FF: synthetic field
   final SelectionHistoryTree this$0;

   private SelectionHistoryTree$InternalMouseListener(SelectionHistoryTree var1) {
      this.this$0 = var1;
   }

   public void mousePressed(MouseEvent var1) {
      SelectionHistoryTree.access$100(this.this$0, var1);
   }

   public void mouseReleased(MouseEvent var1) {
      SelectionHistoryTree.access$100(this.this$0, var1);
   }

   // $FF: synthetic method
   SelectionHistoryTree$InternalMouseListener(SelectionHistoryTree var1, SelectionHistoryTree$1 var2) {
      this(var1);
   }
}
