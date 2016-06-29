package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet$Builder;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$Builder extends ImmutableSet$Builder {
   private final Comparator comparator;

   public ImmutableSortedSet$Builder(Comparator var1) {
      this.comparator = (Comparator)Preconditions.checkNotNull(var1);
   }

   public ImmutableSortedSet$Builder add(Object var1) {
      super.add(var1);
      return this;
   }

   public ImmutableSortedSet$Builder add(Object... var1) {
      super.add(var1);
      return this;
   }

   public ImmutableSortedSet$Builder addAll(Iterable var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableSortedSet$Builder addAll(Iterator var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableSortedSet build() {
      Object[] var1 = (Object[])this.contents;
      ImmutableSortedSet var2 = ImmutableSortedSet.construct(this.comparator, this.size, var1);
      this.size = var2.size();
      return var2;
   }
}
