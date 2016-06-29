package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$ColumnKeyIterator extends AbstractIterator {
   final Map seen;
   final Iterator mapIterator;
   Iterator entryIterator;
   // $FF: synthetic field
   final StandardTable this$0;

   private StandardTable$ColumnKeyIterator(StandardTable var1) {
      this.this$0 = var1;
      this.seen = (Map)this.this$0.factory.get();
      this.mapIterator = this.this$0.backingMap.values().iterator();
      this.entryIterator = Iterators.emptyIterator();
   }

   protected Object computeNext() {
      while(true) {
         if(this.entryIterator.hasNext()) {
            Entry var1 = (Entry)this.entryIterator.next();
            if(!this.seen.containsKey(var1.getKey())) {
               this.seen.put(var1.getKey(), var1.getValue());
               return var1.getKey();
            }
         } else {
            if(!this.mapIterator.hasNext()) {
               return this.endOfData();
            }

            this.entryIterator = ((Map)this.mapIterator.next()).entrySet().iterator();
         }
      }
   }

   // $FF: synthetic method
   StandardTable$ColumnKeyIterator(StandardTable var1, StandardTable$1 var2) {
      this(var1);
   }
}
