package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import java.io.Serializable;

class ImmutableMultiset$EntrySetSerializedForm implements Serializable {
   final ImmutableMultiset multiset;

   ImmutableMultiset$EntrySetSerializedForm(ImmutableMultiset var1) {
      this.multiset = var1;
   }

   Object readResolve() {
      return this.multiset.entrySet();
   }
}
