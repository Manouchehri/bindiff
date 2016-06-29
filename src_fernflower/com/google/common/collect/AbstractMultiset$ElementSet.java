package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$ElementSet;

class AbstractMultiset$ElementSet extends Multisets$ElementSet {
   // $FF: synthetic field
   final AbstractMultiset this$0;

   AbstractMultiset$ElementSet(AbstractMultiset var1) {
      this.this$0 = var1;
   }

   Multiset multiset() {
      return this.this$0;
   }
}
