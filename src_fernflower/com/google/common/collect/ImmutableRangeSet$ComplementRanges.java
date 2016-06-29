package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;

final class ImmutableRangeSet$ComplementRanges extends ImmutableList {
   private final boolean positiveBoundedBelow;
   private final boolean positiveBoundedAbove;
   private final int size;
   // $FF: synthetic field
   final ImmutableRangeSet this$0;

   ImmutableRangeSet$ComplementRanges(ImmutableRangeSet var1) {
      this.this$0 = var1;
      this.positiveBoundedBelow = ((Range)ImmutableRangeSet.access$000(var1).get(0)).hasLowerBound();
      this.positiveBoundedAbove = ((Range)Iterables.getLast(ImmutableRangeSet.access$000(var1))).hasUpperBound();
      int var2 = ImmutableRangeSet.access$000(var1).size() - 1;
      if(this.positiveBoundedBelow) {
         ++var2;
      }

      if(this.positiveBoundedAbove) {
         ++var2;
      }

      this.size = var2;
   }

   public int size() {
      return this.size;
   }

   public Range get(int var1) {
      Preconditions.checkElementIndex(var1, this.size);
      Cut var2;
      if(this.positiveBoundedBelow) {
         var2 = var1 == 0?Cut.belowAll():((Range)ImmutableRangeSet.access$000(this.this$0).get(var1 - 1)).upperBound;
      } else {
         var2 = ((Range)ImmutableRangeSet.access$000(this.this$0).get(var1)).upperBound;
      }

      Cut var3;
      if(this.positiveBoundedAbove && var1 == this.size - 1) {
         var3 = Cut.aboveAll();
      } else {
         var3 = ((Range)ImmutableRangeSet.access$000(this.this$0).get(var1 + (this.positiveBoundedBelow?0:1))).lowerBound;
      }

      return Range.create(var2, var3);
   }

   boolean isPartialView() {
      return true;
   }
}
