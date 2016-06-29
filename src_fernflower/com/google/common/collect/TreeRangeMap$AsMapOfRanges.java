package com.google.common.collect;

import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import java.util.Iterator;
import javax.annotation.Nullable;

final class TreeRangeMap$AsMapOfRanges extends Maps$IteratorBasedAbstractMap {
   final Iterable entryIterable;
   // $FF: synthetic field
   final TreeRangeMap this$0;

   TreeRangeMap$AsMapOfRanges(TreeRangeMap var1, Iterable var2) {
      this.this$0 = var1;
      this.entryIterable = var2;
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.get(var1) != null;
   }

   public Object get(@Nullable Object var1) {
      if(var1 instanceof Range) {
         Range var2 = (Range)var1;
         TreeRangeMap$RangeMapEntry var3 = (TreeRangeMap$RangeMapEntry)TreeRangeMap.access$000(this.this$0).get(var2.lowerBound);
         if(var3 != null && var3.getKey().equals(var2)) {
            return var3.getValue();
         }
      }

      return null;
   }

   public int size() {
      return TreeRangeMap.access$000(this.this$0).size();
   }

   Iterator entryIterator() {
      return this.entryIterable.iterator();
   }
}
