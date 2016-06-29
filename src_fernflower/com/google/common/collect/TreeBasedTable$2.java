package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.Iterator;

class TreeBasedTable$2 extends AbstractIterator {
   Object lastValue;
   // $FF: synthetic field
   final Iterator val$merged;
   // $FF: synthetic field
   final Comparator val$comparator;
   // $FF: synthetic field
   final TreeBasedTable this$0;

   TreeBasedTable$2(TreeBasedTable var1, Iterator var2, Comparator var3) {
      this.this$0 = var1;
      this.val$merged = var2;
      this.val$comparator = var3;
   }

   protected Object computeNext() {
      Object var1;
      boolean var2;
      do {
         if(!this.val$merged.hasNext()) {
            this.lastValue = null;
            return this.endOfData();
         }

         var1 = this.val$merged.next();
         var2 = this.lastValue != null && this.val$comparator.compare(var1, this.lastValue) == 0;
      } while(var2);

      this.lastValue = var1;
      return this.lastValue;
   }
}
