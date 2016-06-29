package com.google.common.collect;

import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.ForwardingSortedMultiset;
import com.google.common.collect.SortedMultiset;

public abstract class ForwardingSortedMultiset$StandardDescendingMultiset extends DescendingMultiset {
   // $FF: synthetic field
   final ForwardingSortedMultiset this$0;

   public ForwardingSortedMultiset$StandardDescendingMultiset(ForwardingSortedMultiset var1) {
      this.this$0 = var1;
   }

   SortedMultiset forwardMultiset() {
      return this.this$0;
   }
}
