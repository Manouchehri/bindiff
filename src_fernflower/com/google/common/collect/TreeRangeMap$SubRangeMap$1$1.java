package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1;
import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$1$1 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$backingItr;
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap$1 this$2;

   TreeRangeMap$SubRangeMap$1$1(TreeRangeMap$SubRangeMap$1 var1, Iterator var2) {
      this.this$2 = var1;
      this.val$backingItr = var2;
   }

   protected Entry computeNext() {
      if(this.val$backingItr.hasNext()) {
         TreeRangeMap$RangeMapEntry var1 = (TreeRangeMap$RangeMapEntry)this.val$backingItr.next();
         return var1.getUpperBound().compareTo(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1).lowerBound) <= 0?(Entry)this.endOfData():Maps.immutableEntry(var1.getKey().intersection(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1)), var1.getValue());
      } else {
         return (Entry)this.endOfData();
      }
   }
}
