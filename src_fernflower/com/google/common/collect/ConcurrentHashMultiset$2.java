package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

class ConcurrentHashMultiset$2 extends AbstractIterator {
   private Iterator mapEntries;
   // $FF: synthetic field
   final ConcurrentHashMultiset this$0;

   ConcurrentHashMultiset$2(ConcurrentHashMultiset var1) {
      this.this$0 = var1;
      this.mapEntries = ConcurrentHashMultiset.access$100(this.this$0).entrySet().iterator();
   }

   protected Multiset$Entry computeNext() {
      Entry var1;
      int var2;
      do {
         if(!this.mapEntries.hasNext()) {
            return (Multiset$Entry)this.endOfData();
         }

         var1 = (Entry)this.mapEntries.next();
         var2 = ((AtomicInteger)var1.getValue()).get();
      } while(var2 == 0);

      return Multisets.immutableEntry(var1.getKey(), var2);
   }
}
