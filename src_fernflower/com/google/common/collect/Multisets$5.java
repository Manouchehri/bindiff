package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

final class Multisets$5 extends Ordering {
   public int compare(Multiset$Entry var1, Multiset$Entry var2) {
      return Ints.compare(var2.getCount(), var1.getCount());
   }
}
