package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$FilteredMultiset$1;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$FilteredMultiset extends AbstractMultiset {
   final Multiset unfiltered;
   final Predicate predicate;

   Multisets$FilteredMultiset(Multiset var1, Predicate var2) {
      this.unfiltered = (Multiset)Preconditions.checkNotNull(var1);
      this.predicate = (Predicate)Preconditions.checkNotNull(var2);
   }

   public UnmodifiableIterator iterator() {
      return Iterators.filter(this.unfiltered.iterator(), this.predicate);
   }

   Set createElementSet() {
      return Sets.filter(this.unfiltered.elementSet(), this.predicate);
   }

   Set createEntrySet() {
      return Sets.filter((Set)this.unfiltered.entrySet(), new Multisets$FilteredMultiset$1(this));
   }

   Iterator entryIterator() {
      throw new AssertionError("should never be called");
   }

   int distinctElements() {
      return this.elementSet().size();
   }

   public int count(@Nullable Object var1) {
      int var2 = this.unfiltered.count(var1);
      return var2 > 0?(this.predicate.apply(var1)?var2:0):0;
   }

   public int add(@Nullable Object var1, int var2) {
      Preconditions.checkArgument(this.predicate.apply(var1), "Element %s does not match predicate %s", new Object[]{var1, this.predicate});
      return this.unfiltered.add(var1, var2);
   }

   public int remove(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "occurrences");
      return var2 == 0?this.count(var1):(this.contains(var1)?this.unfiltered.remove(var1, var2):0);
   }

   public void clear() {
      this.elementSet().clear();
   }
}
