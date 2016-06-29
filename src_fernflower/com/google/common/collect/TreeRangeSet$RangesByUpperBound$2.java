package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Map.Entry;

class TreeRangeSet$RangesByUpperBound$2 extends AbstractIterator {
   // $FF: synthetic field
   final PeekingIterator val$backingItr;
   // $FF: synthetic field
   final TreeRangeSet$RangesByUpperBound this$0;

   TreeRangeSet$RangesByUpperBound$2(TreeRangeSet$RangesByUpperBound var1, PeekingIterator var2) {
      this.this$0 = var1;
      this.val$backingItr = var2;
   }

   protected Entry computeNext() {
      if(!this.val$backingItr.hasNext()) {
         return (Entry)this.endOfData();
      } else {
         Range var1 = (Range)this.val$backingItr.next();
         return TreeRangeSet$RangesByUpperBound.access$000(this.this$0).lowerBound.isLessThan(var1.upperBound)?Maps.immutableEntry(var1.upperBound, var1):(Entry)this.endOfData();
      }
   }
}
