package com.google.common.base;

import com.google.common.base.Pair;
import java.util.Comparator;

enum Pair$FirstComparator implements Comparator {
   FIRST_COMPARATOR;

   public int compare(Pair var1, Pair var2) {
      Comparable var3 = (Comparable)var1.getFirst();
      Comparable var4 = (Comparable)var2.getFirst();
      int var5 = var3.compareTo(var4);
      return var5;
   }
}
