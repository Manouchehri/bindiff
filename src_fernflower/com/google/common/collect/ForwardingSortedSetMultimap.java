package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingSetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap extends ForwardingSetMultimap implements SortedSetMultimap {
   protected abstract SortedSetMultimap delegate();

   public SortedSet get(@Nullable Object var1) {
      return this.delegate().get(var1);
   }

   public SortedSet removeAll(@Nullable Object var1) {
      return this.delegate().removeAll(var1);
   }

   public SortedSet replaceValues(Object var1, Iterable var2) {
      return this.delegate().replaceValues(var1, var2);
   }

   public Comparator valueComparator() {
      return this.delegate().valueComparator();
   }
}
