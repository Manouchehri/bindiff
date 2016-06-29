package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionSnapshot;

public class SelectionHistoryTreeNodeWrapper {
   private final SelectionSnapshot operation;
   private final int count;

   public SelectionHistoryTreeNodeWrapper(SelectionSnapshot var1, int var2) {
      this.operation = var1;
      this.count = var2;
   }

   public String toString() {
      return String.format("%d-%s (%d)", new Object[]{Integer.valueOf(this.count), this.operation.getDescription(), Integer.valueOf(this.operation.getSelection().size())});
   }
}
