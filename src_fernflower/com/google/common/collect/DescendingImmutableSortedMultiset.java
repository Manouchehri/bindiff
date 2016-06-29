package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset$Entry;
import javax.annotation.Nullable;

final class DescendingImmutableSortedMultiset extends ImmutableSortedMultiset {
   private final transient ImmutableSortedMultiset forward;

   DescendingImmutableSortedMultiset(ImmutableSortedMultiset var1) {
      this.forward = var1;
   }

   public int count(@Nullable Object var1) {
      return this.forward.count(var1);
   }

   public Multiset$Entry firstEntry() {
      return this.forward.lastEntry();
   }

   public Multiset$Entry lastEntry() {
      return this.forward.firstEntry();
   }

   public int size() {
      return this.forward.size();
   }

   public ImmutableSortedSet elementSet() {
      return this.forward.elementSet().descendingSet();
   }

   Multiset$Entry getEntry(int var1) {
      return (Multiset$Entry)this.forward.entrySet().asList().reverse().get(var1);
   }

   public ImmutableSortedMultiset descendingMultiset() {
      return this.forward;
   }

   public ImmutableSortedMultiset headMultiset(Object var1, BoundType var2) {
      return this.forward.tailMultiset(var1, var2).descendingMultiset();
   }

   public ImmutableSortedMultiset tailMultiset(Object var1, BoundType var2) {
      return this.forward.headMultiset(var1, var2).descendingMultiset();
   }

   boolean isPartialView() {
      return this.forward.isPartialView();
   }
}
