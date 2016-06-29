package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import java.util.Comparator;
import java.util.List;

public enum SortedLists$KeyPresentBehavior {
   ANY_PRESENT,
   LAST_PRESENT,
   FIRST_PRESENT,
   FIRST_AFTER,
   LAST_BEFORE;

   private SortedLists$KeyPresentBehavior() {
   }

   abstract int resultIndex(Comparator var1, Object var2, List var3, int var4);

   // $FF: synthetic method
   SortedLists$KeyPresentBehavior(SortedLists$1 var3) {
      this();
   }
}
