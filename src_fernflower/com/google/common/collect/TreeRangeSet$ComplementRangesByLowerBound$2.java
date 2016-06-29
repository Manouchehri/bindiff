package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound;
import java.util.Map.Entry;

class TreeRangeSet$ComplementRangesByLowerBound$2 extends AbstractIterator {
   Cut nextComplementRangeUpperBound;
   // $FF: synthetic field
   final Cut val$firstComplementRangeUpperBound;
   // $FF: synthetic field
   final PeekingIterator val$positiveItr;
   // $FF: synthetic field
   final TreeRangeSet$ComplementRangesByLowerBound this$0;

   TreeRangeSet$ComplementRangesByLowerBound$2(TreeRangeSet$ComplementRangesByLowerBound var1, Cut var2, PeekingIterator var3) {
      this.this$0 = var1;
      this.val$firstComplementRangeUpperBound = var2;
      this.val$positiveItr = var3;
      this.nextComplementRangeUpperBound = this.val$firstComplementRangeUpperBound;
   }

   protected Entry computeNext() {
      if(this.nextComplementRangeUpperBound == Cut.belowAll()) {
         return (Entry)this.endOfData();
      } else {
         Range var1;
         if(this.val$positiveItr.hasNext()) {
            var1 = (Range)this.val$positiveItr.next();
            Range var2 = Range.create(var1.upperBound, this.nextComplementRangeUpperBound);
            this.nextComplementRangeUpperBound = var1.lowerBound;
            if(TreeRangeSet$ComplementRangesByLowerBound.access$100(this.this$0).lowerBound.isLessThan(var2.lowerBound)) {
               return Maps.immutableEntry(var2.lowerBound, var2);
            }
         } else if(TreeRangeSet$ComplementRangesByLowerBound.access$100(this.this$0).lowerBound.isLessThan(Cut.belowAll())) {
            var1 = Range.create(Cut.belowAll(), this.nextComplementRangeUpperBound);
            this.nextComplementRangeUpperBound = Cut.belowAll();
            return Maps.immutableEntry(Cut.belowAll(), var1);
         }

         return (Entry)this.endOfData();
      }
   }
}
