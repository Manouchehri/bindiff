package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$1;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

class CTableSorter$TableModelHandler implements TableModelListener {
   // $FF: synthetic field
   final CTableSorter this$0;

   private CTableSorter$TableModelHandler(CTableSorter var1) {
      this.this$0 = var1;
   }

   public void tableChanged(TableModelEvent var1) {
      if(!this.this$0.isSorting()) {
         this.this$0.clearSortingState();
         this.this$0.fireTableChanged(var1);
      } else if(var1.getFirstRow() == -1) {
         this.this$0.cancelSorting();
         this.this$0.fireTableChanged(var1);
      } else {
         int var2 = var1.getColumn();
         if(var1.getFirstRow() == var1.getLastRow() && var2 != -1 && this.this$0.getSortingStatus(var2) == 0 && this.this$0.modelToView != null) {
            int var3 = this.this$0.getModelToView()[var1.getFirstRow()];
            this.this$0.fireTableChanged(new TableModelEvent(this.this$0, var3, var3, var2, var1.getType()));
         } else {
            this.this$0.clearSortingState();
            this.this$0.fireTableDataChanged();
         }
      }
   }

   // $FF: synthetic method
   CTableSorter$TableModelHandler(CTableSorter var1, CTableSorter$1 var2) {
      this(var1);
   }
}
