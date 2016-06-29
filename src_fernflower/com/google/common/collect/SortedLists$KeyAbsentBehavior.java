package com.google.common.collect;

import com.google.common.collect.SortedLists$1;

public enum SortedLists$KeyAbsentBehavior {
   NEXT_LOWER,
   NEXT_HIGHER,
   INVERTED_INSERTION_INDEX;

   private SortedLists$KeyAbsentBehavior() {
   }

   abstract int resultIndex(int var1);

   // $FF: synthetic method
   SortedLists$KeyAbsentBehavior(SortedLists$1 var3) {
      this();
   }
}
