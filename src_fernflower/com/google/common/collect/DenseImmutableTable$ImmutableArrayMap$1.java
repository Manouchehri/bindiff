package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.Maps;
import java.util.Map.Entry;

class DenseImmutableTable$ImmutableArrayMap$1 extends AbstractIterator {
   private int index;
   private final int maxIndex;
   // $FF: synthetic field
   final DenseImmutableTable$ImmutableArrayMap this$0;

   DenseImmutableTable$ImmutableArrayMap$1(DenseImmutableTable$ImmutableArrayMap var1) {
      this.this$0 = var1;
      this.index = -1;
      this.maxIndex = this.this$0.keyToIndex().size();
   }

   protected Entry computeNext() {
      ++this.index;

      while(this.index < this.maxIndex) {
         Object var1 = this.this$0.getValue(this.index);
         if(var1 != null) {
            return Maps.immutableEntry(this.this$0.getKey(this.index), var1);
         }

         ++this.index;
      }

      return (Entry)this.endOfData();
   }
}
