package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.RegularContiguousSet;

class RegularContiguousSet$1 extends AbstractSequentialIterator {
   final Comparable last;
   // $FF: synthetic field
   final RegularContiguousSet this$0;

   RegularContiguousSet$1(RegularContiguousSet var1, Comparable var2) {
      super(var2);
      this.this$0 = var1;
      this.last = this.this$0.last();
   }

   protected Comparable computeNext(Comparable var1) {
      return RegularContiguousSet.access$000(var1, this.last)?null:this.this$0.domain.next(var1);
   }
}
