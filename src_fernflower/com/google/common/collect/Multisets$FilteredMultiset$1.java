package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$FilteredMultiset;

class Multisets$FilteredMultiset$1 implements Predicate {
   // $FF: synthetic field
   final Multisets$FilteredMultiset this$0;

   Multisets$FilteredMultiset$1(Multisets$FilteredMultiset var1) {
      this.this$0 = var1;
   }

   public boolean apply(Multiset$Entry var1) {
      return this.this$0.predicate.apply(var1.getElement());
   }
}
