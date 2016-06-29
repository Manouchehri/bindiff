package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound;
import java.util.Map.Entry;

class TreeRangeSet$ComplementRangesByLowerBound$1 extends AbstractIterator {
   Cut nextComplementRangeLowerBound;
   // $FF: synthetic field
   final Cut val$firstComplementRangeLowerBound;
   // $FF: synthetic field
   final PeekingIterator val$positiveItr;
   // $FF: synthetic field
   final TreeRangeSet$ComplementRangesByLowerBound this$0;

   TreeRangeSet$ComplementRangesByLowerBound$1(TreeRangeSet$ComplementRangesByLowerBound var1, Cut var2, PeekingIterator var3) {
      this.this$0 = var1;
      this.val$firstComplementRangeLowerBound = var2;
      this.val$positiveItr = var3;
      this.nextComplementRangeLowerBound = this.val$firstComplementRangeLowerBound;
   }

   protected Entry computeNext() {
      if(!TreeRangeSet$ComplementRangesByLowerBound.access$100(this.this$0).upperBound.isLessThan(this.nextComplementRangeLowerBound) && this.nextComplementRangeLowerBound != Cut.aboveAll()) {
         Range var1;
         if(this.val$positiveItr.hasNext()) {
            Range var2 = (Range)this.val$positiveItr.next();
            var1 = Range.create(this.nextComplementRangeLowerBound, var2.lowerBound);
            this.nextComplementRangeLowerBound = var2.upperBound;
         } else {
            var1 = Range.create(this.nextComplementRangeLowerBound, Cut.aboveAll());
            this.nextComplementRangeLowerBound = Cut.aboveAll();
         }

         return Maps.immutableEntry(var1.lowerBound, var1);
      } else {
         return (Entry)this.endOfData();
      }
   }
}
