package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

enum SortedLists$KeyPresentBehavior$4 {
   public int resultIndex(Comparator var1, Object var2, List var3, int var4) {
      return LAST_PRESENT.resultIndex(var1, var2, var3, var4) + 1;
   }
}
