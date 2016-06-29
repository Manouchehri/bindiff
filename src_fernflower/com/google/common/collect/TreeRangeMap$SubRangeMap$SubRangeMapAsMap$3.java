package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$backingItr;
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

   TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(TreeRangeMap$SubRangeMap$SubRangeMapAsMap var1, Iterator var2) {
      this.this$2 = var1;
      this.val$backingItr = var2;
   }

   protected Entry computeNext() {
      while(true) {
         if(this.val$backingItr.hasNext()) {
            TreeRangeMap$RangeMapEntry var1 = (TreeRangeMap$RangeMapEntry)this.val$backingItr.next();
            if(var1.getLowerBound().compareTo(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1).upperBound) >= 0) {
               return (Entry)this.endOfData();
            }

            if(var1.getUpperBound().compareTo(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1).lowerBound) <= 0) {
               continue;
            }

            return Maps.immutableEntry(var1.getKey().intersection(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1)), var1.getValue());
         }

         return (Entry)this.endOfData();
      }
   }
}
