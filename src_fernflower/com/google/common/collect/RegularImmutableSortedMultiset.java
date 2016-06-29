package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.Nullable;

final class RegularImmutableSortedMultiset extends ImmutableSortedMultiset {
   private static final long[] ZERO_CUMULATIVE_COUNTS = new long[]{0L};
   private final transient RegularImmutableSortedSet elementSet;
   private final transient long[] cumulativeCounts;
   private final transient int offset;
   private final transient int length;

   RegularImmutableSortedMultiset(Comparator var1) {
      this.elementSet = ImmutableSortedSet.emptySet(var1);
      this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
      this.offset = 0;
      this.length = 0;
   }

   RegularImmutableSortedMultiset(RegularImmutableSortedSet var1, long[] var2, int var3, int var4) {
      this.elementSet = var1;
      this.cumulativeCounts = var2;
      this.offset = var3;
      this.length = var4;
   }

   private int getCount(int var1) {
      return (int)(this.cumulativeCounts[this.offset + var1 + 1] - this.cumulativeCounts[this.offset + var1]);
   }

   Multiset$Entry getEntry(int var1) {
      return Multisets.immutableEntry(this.elementSet.asList().get(var1), this.getCount(var1));
   }

   public Multiset$Entry firstEntry() {
      return this.isEmpty()?null:this.getEntry(0);
   }

   public Multiset$Entry lastEntry() {
      return this.isEmpty()?null:this.getEntry(this.length - 1);
   }

   public int count(@Nullable Object var1) {
      int var2 = this.elementSet.indexOf(var1);
      return var2 >= 0?this.getCount(var2):0;
   }

   public int size() {
      long var1 = this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset];
      return Ints.saturatedCast(var1);
   }

   public ImmutableSortedSet elementSet() {
      return this.elementSet;
   }

   public ImmutableSortedMultiset headMultiset(Object var1, BoundType var2) {
      return this.getSubMultiset(0, this.elementSet.headIndex(var1, Preconditions.checkNotNull(var2) == BoundType.CLOSED));
   }

   public ImmutableSortedMultiset tailMultiset(Object var1, BoundType var2) {
      return this.getSubMultiset(this.elementSet.tailIndex(var1, Preconditions.checkNotNull(var2) == BoundType.CLOSED), this.length);
   }

   ImmutableSortedMultiset getSubMultiset(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, this.length);
      if(var1 == var2) {
         return emptyMultiset(this.comparator());
      } else if(var1 == 0 && var2 == this.length) {
         return this;
      } else {
         RegularImmutableSortedSet var3 = this.elementSet.getSubSet(var1, var2);
         return new RegularImmutableSortedMultiset(var3, this.cumulativeCounts, this.offset + var1, var2 - var1);
      }
   }

   boolean isPartialView() {
      return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
   }
}
