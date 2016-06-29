package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$Column$EntrySetIterator$1EntryImpl;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Column$EntrySetIterator extends AbstractIterator {
   final Iterator iterator;
   // $FF: synthetic field
   final StandardTable$Column this$1;

   private StandardTable$Column$EntrySetIterator(StandardTable$Column var1) {
      this.this$1 = var1;
      this.iterator = this.this$1.this$0.backingMap.entrySet().iterator();
   }

   protected Entry computeNext() {
      while(true) {
         if(this.iterator.hasNext()) {
            Entry var1 = (Entry)this.iterator.next();
            if(!((Map)var1.getValue()).containsKey(this.this$1.columnKey)) {
               continue;
            }

            return new StandardTable$Column$EntrySetIterator$1EntryImpl(this, var1);
         }

         return (Entry)this.endOfData();
      }
   }

   // $FF: synthetic method
   StandardTable$Column$EntrySetIterator(StandardTable$Column var1, StandardTable$1 var2) {
      this(var1);
   }
}
