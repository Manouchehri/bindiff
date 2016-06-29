package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$RangesByUpperBound$1 extends AbstractIterator {
   // $FF: synthetic field
   final Iterator val$backingItr;
   // $FF: synthetic field
   final TreeRangeSet$RangesByUpperBound this$0;

   TreeRangeSet$RangesByUpperBound$1(TreeRangeSet$RangesByUpperBound var1, Iterator var2) {
      this.this$0 = var1;
      this.val$backingItr = var2;
   }

   protected Entry computeNext() {
      if(!this.val$backingItr.hasNext()) {
         return (Entry)this.endOfData();
      } else {
         Range var1 = (Range)this.val$backingItr.next();
         return TreeRangeSet$RangesByUpperBound.access$000(this.this$0).upperBound.isLessThan(var1.upperBound)?(Entry)this.endOfData():Maps.immutableEntry(var1.upperBound, var1);
      }
   }
}
