package com.google.security.zynamics.zylib.gui.tables;

import com.google.security.zynamics.zylib.gui.tables.CTableSorter;
import com.google.security.zynamics.zylib.gui.tables.CTableSorter$Directive;
import java.util.Iterator;

class CTableSorter$Row implements Comparable {
   protected int modelIndex;
   // $FF: synthetic field
   final CTableSorter this$0;

   public CTableSorter$Row(CTableSorter var1, int var2) {
      this.this$0 = var1;
      this.modelIndex = var2;
   }

   public int compareTo(Object var1) {
      int var2 = this.modelIndex;
      int var3 = ((CTableSorter$Row)var1).modelIndex;
      Iterator var4 = this.this$0.sortingColumns.iterator();

      CTableSorter$Directive var6;
      int var11;
      do {
         if(!var4.hasNext()) {
            return 0;
         }

         Object var5 = var4.next();
         var6 = (CTableSorter$Directive)var5;
         int var7 = var6.column;
         Object var8 = this.this$0.tableModel.getValueAt(var2, var7);
         Object var9 = this.this$0.tableModel.getValueAt(var3, var7);
         boolean var10 = false;
         if(var8 == null && var9 == null) {
            var11 = 0;
         } else if(var8 == null) {
            var11 = -1;
         } else if(var9 == null) {
            var11 = 1;
         } else {
            var11 = this.this$0.getComparator(var7).compare(var8, var9);
         }
      } while(var11 == 0);

      return var6.direction == -1?-var11:var11;
   }
}
