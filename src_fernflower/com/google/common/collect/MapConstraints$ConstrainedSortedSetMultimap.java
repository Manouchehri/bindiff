package com.google.common.collect;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedSetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;

class MapConstraints$ConstrainedSortedSetMultimap extends MapConstraints$ConstrainedSetMultimap implements SortedSetMultimap {
   MapConstraints$ConstrainedSortedSetMultimap(SortedSetMultimap var1, MapConstraint var2) {
      super(var1, var2);
   }

   public SortedSet get(Object var1) {
      return (SortedSet)super.get(var1);
   }

   public SortedSet removeAll(Object var1) {
      return (SortedSet)super.removeAll(var1);
   }

   public SortedSet replaceValues(Object var1, Iterable var2) {
      return (SortedSet)super.replaceValues(var1, var2);
   }

   public Comparator valueComparator() {
      return ((SortedSetMultimap)this.delegate()).valueComparator();
   }
}
