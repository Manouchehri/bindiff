package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;

class ImmutableRangeSet$1 extends ImmutableList {
   // $FF: synthetic field
   final int val$length;
   // $FF: synthetic field
   final int val$fromIndex;
   // $FF: synthetic field
   final Range val$range;
   // $FF: synthetic field
   final ImmutableRangeSet this$0;

   ImmutableRangeSet$1(ImmutableRangeSet var1, int var2, int var3, Range var4) {
      this.this$0 = var1;
      this.val$length = var2;
      this.val$fromIndex = var3;
      this.val$range = var4;
   }

   public int size() {
      return this.val$length;
   }

   public Range get(int var1) {
      Preconditions.checkElementIndex(var1, this.val$length);
      return var1 != 0 && var1 != this.val$length - 1?(Range)ImmutableRangeSet.access$000(this.this$0).get(var1 + this.val$fromIndex):((Range)ImmutableRangeSet.access$000(this.this$0).get(var1 + this.val$fromIndex)).intersection(this.val$range);
   }

   boolean isPartialView() {
      return true;
   }
}
