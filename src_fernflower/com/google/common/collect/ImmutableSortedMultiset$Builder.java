package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;
import java.util.Comparator;
import java.util.Iterator;

public class ImmutableSortedMultiset$Builder extends ImmutableMultiset$Builder {
   public ImmutableSortedMultiset$Builder(Comparator var1) {
      super(TreeMultiset.create((Comparator)Preconditions.checkNotNull(var1)));
   }

   public ImmutableSortedMultiset$Builder add(Object var1) {
      super.add(var1);
      return this;
   }

   public ImmutableSortedMultiset$Builder addCopies(Object var1, int var2) {
      super.addCopies(var1, var2);
      return this;
   }

   public ImmutableSortedMultiset$Builder setCount(Object var1, int var2) {
      super.setCount(var1, var2);
      return this;
   }

   public ImmutableSortedMultiset$Builder add(Object... var1) {
      super.add(var1);
      return this;
   }

   public ImmutableSortedMultiset$Builder addAll(Iterable var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableSortedMultiset$Builder addAll(Iterator var1) {
      super.addAll(var1);
      return this;
   }

   public ImmutableSortedMultiset build() {
      return ImmutableSortedMultiset.copyOfSorted((SortedMultiset)this.contents);
   }
}
