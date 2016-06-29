package com.google.common.collect;

import com.google.common.collect.Multimaps$UnmodifiableSetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;

class Multimaps$UnmodifiableSortedSetMultimap extends Multimaps$UnmodifiableSetMultimap implements SortedSetMultimap {
   private static final long serialVersionUID = 0L;

   Multimaps$UnmodifiableSortedSetMultimap(SortedSetMultimap var1) {
      super(var1);
   }

   public SortedSetMultimap delegate() {
      return (SortedSetMultimap)super.delegate();
   }

   public SortedSet get(Object var1) {
      return Collections.unmodifiableSortedSet(this.delegate().get(var1));
   }

   public SortedSet removeAll(Object var1) {
      throw new UnsupportedOperationException();
   }

   public SortedSet replaceValues(Object var1, Iterable var2) {
      throw new UnsupportedOperationException();
   }

   public Comparator valueComparator() {
      return this.delegate().valueComparator();
   }
}
