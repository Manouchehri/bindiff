package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound;
import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$SubRangeSetRangesByLowerBound$2 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$completeRangeItr;
   // $FF: synthetic field
   final TreeRangeSet$SubRangeSetRangesByLowerBound this$0;

   TreeRangeSet$SubRangeSetRangesByLowerBound$2(TreeRangeSet$SubRangeSetRangesByLowerBound var1, Iterator var2) {
      this.this$0 = var1;
      this.val$completeRangeItr = var2;
   }

   protected Entry computeNext() {
      if(!this.val$completeRangeItr.hasNext()) {
         return (Entry)this.endOfData();
      } else {
         Range var1 = (Range)this.val$completeRangeItr.next();
         if(TreeRangeSet$SubRangeSetRangesByLowerBound.access$300(this.this$0).lowerBound.compareTo(var1.upperBound) >= 0) {
            return (Entry)this.endOfData();
         } else {
            var1 = var1.intersection(TreeRangeSet$SubRangeSetRangesByLowerBound.access$300(this.this$0));
            return TreeRangeSet$SubRangeSetRangesByLowerBound.access$400(this.this$0).contains(var1.lowerBound)?Maps.immutableEntry(var1.lowerBound, var1):(Entry)this.endOfData();
         }
      }
   }
}
