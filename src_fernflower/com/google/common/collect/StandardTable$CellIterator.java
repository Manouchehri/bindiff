package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$CellIterator implements Iterator {
   final Iterator rowIterator;
   Entry rowEntry;
   Iterator columnIterator;
   // $FF: synthetic field
   final StandardTable this$0;

   private StandardTable$CellIterator(StandardTable var1) {
      this.this$0 = var1;
      this.rowIterator = this.this$0.backingMap.entrySet().iterator();
      this.columnIterator = Iterators.emptyModifiableIterator();
   }

   public boolean hasNext() {
      return this.rowIterator.hasNext() || this.columnIterator.hasNext();
   }

   public Table$Cell next() {
      if(!this.columnIterator.hasNext()) {
         this.rowEntry = (Entry)this.rowIterator.next();
         this.columnIterator = ((Map)this.rowEntry.getValue()).entrySet().iterator();
      }

      Entry var1 = (Entry)this.columnIterator.next();
      return Tables.immutableCell(this.rowEntry.getKey(), var1.getKey(), var1.getValue());
   }

   public void remove() {
      this.columnIterator.remove();
      if(((Map)this.rowEntry.getValue()).isEmpty()) {
         this.rowIterator.remove();
      }

   }

   // $FF: synthetic method
   StandardTable$CellIterator(StandardTable var1, StandardTable$1 var2) {
      this(var1);
   }
}
