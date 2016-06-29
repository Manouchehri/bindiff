package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.RegularContiguousSet;

class RegularContiguousSet$2 extends AbstractSequentialIterator {
   final Comparable first;
   // $FF: synthetic field
   final RegularContiguousSet this$0;

   RegularContiguousSet$2(RegularContiguousSet var1, Comparable var2) {
      super(var2);
      this.this$0 = var1;
      this.first = this.this$0.first();
   }

   protected Comparable computeNext(Comparable var1) {
      return RegularContiguousSet.access$000(var1, this.first)?null:this.this$0.domain.previous(var1);
   }
}
