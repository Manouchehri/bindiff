package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$1;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

class CTableSorter$MouseHandler extends MouseAdapter {
   // $FF: synthetic field
   final CTableSorter this$0;

   private CTableSorter$MouseHandler(CTableSorter var1) {
      this.this$0 = var1;
   }

   public void mouseClicked(MouseEvent var1) {
      JTableHeader var2 = (JTableHeader)var1.getSource();
      TableColumnModel var3 = var2.getColumnModel();
      int var4 = var3.getColumnIndexAtX(var1.getX());
      int var5 = var3.getColumn(var4).getModelIndex();
      if(var5 != -1) {
         int var6 = this.this$0.getSortingStatus(var5);
         if(!var1.isControlDown()) {
            this.this$0.cancelSorting();
         }

         var6 += var1.isShiftDown()?-1:1;
         var6 = (var6 + 4) % 3 - 1;
         this.this$0.setSortingStatus(var5, var6);
      }

   }

   // $FF: synthetic method
   CTableSorter$MouseHandler(CTableSorter var1, CTableSorter$1 var2) {
      this(var1);
   }
}
