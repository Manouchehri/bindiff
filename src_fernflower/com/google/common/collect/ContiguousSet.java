package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RegularContiguousSet;
import java.util.NoSuchElementException;

@Beta
@GwtCompatible(
   emulated = true
)
public abstract class ContiguousSet extends ImmutableSortedSet {
   final DiscreteDomain domain;

   public static ContiguousSet create(Range var0, DiscreteDomain var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Range var2 = var0;

      try {
         if(!var0.hasLowerBound()) {
            var2 = var2.intersection(Range.atLeast(var1.minValue()));
         }

         if(!var0.hasUpperBound()) {
            var2 = var2.intersection(Range.atMost(var1.maxValue()));
         }
      } catch (NoSuchElementException var4) {
         throw new IllegalArgumentException(var4);
      }

      boolean var3 = var2.isEmpty() || Range.compareOrThrow(var0.lowerBound.leastValueAbove(var1), var0.upperBound.greatestValueBelow(var1)) > 0;
      return (ContiguousSet)(var3?new EmptyContiguousSet(var1):new RegularContiguousSet(var2, var1));
   }

   ContiguousSet(DiscreteDomain var1) {
      super(Ordering.natural());
      this.domain = var1;
   }

   public ContiguousSet headSet(Comparable var1) {
      return this.headSetImpl((Comparable)Preconditions.checkNotNull(var1), false);
   }

   @GwtIncompatible("NavigableSet")
   public ContiguousSet headSet(Comparable var1, boolean var2) {
      return this.headSetImpl((Comparable)Preconditions.checkNotNull(var1), var2);
   }

   public ContiguousSet subSet(Comparable var1, Comparable var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkArgument(this.comparator().compare(var1, var2) <= 0);
      return this.subSetImpl(var1, true, var2, false);
   }

   @GwtIncompatible("NavigableSet")
   public ContiguousSet subSet(Comparable var1, boolean var2, Comparable var3, boolean var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);
      Preconditions.checkArgument(this.comparator().compare(var1, var3) <= 0);
      return this.subSetImpl(var1, var2, var3, var4);
   }

   public ContiguousSet tailSet(Comparable var1) {
      return this.tailSetImpl((Comparable)Preconditions.checkNotNull(var1), true);
   }

   @GwtIncompatible("NavigableSet")
   public ContiguousSet tailSet(Comparable var1, boolean var2) {
      return this.tailSetImpl((Comparable)Preconditions.checkNotNull(var1), var2);
   }

   abstract ContiguousSet headSetImpl(Comparable var1, boolean var2);

   abstract ContiguousSet subSetImpl(Comparable var1, boolean var2, Comparable var3, boolean var4);

   abstract ContiguousSet tailSetImpl(Comparable var1, boolean var2);

   public abstract ContiguousSet intersection(ContiguousSet var1);

   public abstract Range range();

   public abstract Range range(BoundType var1, BoundType var2);

   public String toString() {
      return this.range().toString();
   }

   @Deprecated
   public static ImmutableSortedSet$Builder builder() {
      throw new UnsupportedOperationException();
   }
}
