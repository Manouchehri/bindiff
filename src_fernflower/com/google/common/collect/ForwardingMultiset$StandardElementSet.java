package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$ElementSet;

@Beta
public class ForwardingMultiset$StandardElementSet extends Multisets$ElementSet {
   // $FF: synthetic field
   final ForwardingMultiset this$0;

   public ForwardingMultiset$StandardElementSet(ForwardingMultiset var1) {
      this.this$0 = var1;
   }

   Multiset multiset() {
      return this.this$0;
   }
}
