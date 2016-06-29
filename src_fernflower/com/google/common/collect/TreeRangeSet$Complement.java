package com.google.common.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound;

final class TreeRangeSet$Complement extends TreeRangeSet {
   // $FF: synthetic field
   final TreeRangeSet this$0;

   TreeRangeSet$Complement(TreeRangeSet var1) {
      super(new TreeRangeSet$ComplementRangesByLowerBound(var1.rangesByLowerBound), (TreeRangeSet$1)null);
      this.this$0 = var1;
   }

   public void add(Range var1) {
      this.this$0.remove(var1);
   }

   public void remove(Range var1) {
      this.this$0.add(var1);
   }

   public boolean contains(Comparable var1) {
      return !this.this$0.contains(var1);
   }

   public RangeSet complement() {
      return this.this$0;
   }
}
