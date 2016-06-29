package com.google.common.primitives;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

@VisibleForTesting
class UnsignedBytes$LexicographicalComparatorHolder {
   static final String UNSAFE_COMPARATOR_NAME = String.valueOf(UnsignedBytes$LexicographicalComparatorHolder.class.getName()).concat("$UnsafeComparator");
   static final Comparator BEST_COMPARATOR = getBestComparator();

   static Comparator getBestComparator() {
      try {
         Class var0 = Class.forName(UNSAFE_COMPARATOR_NAME);
         Comparator var1 = (Comparator)var0.getEnumConstants()[0];
         return var1;
      } catch (Throwable var2) {
         return UnsignedBytes.lexicographicalComparatorJavaImpl();
      }
   }
}
