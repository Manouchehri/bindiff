package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableRangeSet$AsSet$1;
import com.google.common.collect.ImmutableRangeSet$AsSet$2;
import com.google.common.collect.ImmutableRangeSet$AsSetSerializedForm;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import javax.annotation.Nullable;

final class ImmutableRangeSet$AsSet extends ImmutableSortedSet {
   private final DiscreteDomain domain;
   private transient Integer size;
   // $FF: synthetic field
   final ImmutableRangeSet this$0;

   ImmutableRangeSet$AsSet(ImmutableRangeSet var1, DiscreteDomain var2) {
      super(Ordering.natural());
      this.this$0 = var1;
      this.domain = var2;
   }

   public int size() {
      Integer var1 = this.size;
      if(var1 == null) {
         long var2 = 0L;
         UnmodifiableIterator var4 = ImmutableRangeSet.access$000(this.this$0).iterator();

         while(var4.hasNext()) {
            Range var5 = (Range)var4.next();
            var2 += (long)ContiguousSet.create(var5, this.domain).size();
            if(var2 >= 2147483647L) {
               break;
            }
         }

         var1 = this.size = Integer.valueOf(Ints.saturatedCast(var2));
      }

      return var1.intValue();
   }

   public UnmodifiableIterator iterator() {
      return new ImmutableRangeSet$AsSet$1(this);
   }

   @GwtIncompatible("NavigableSet")
   public UnmodifiableIterator descendingIterator() {
      return new ImmutableRangeSet$AsSet$2(this);
   }

   ImmutableSortedSet subSet(Range var1) {
      return this.this$0.subRangeSet(var1).asSet(this.domain);
   }

   ImmutableSortedSet headSetImpl(Comparable var1, boolean var2) {
      return this.subSet(Range.upTo(var1, BoundType.forBoolean(var2)));
   }

   ImmutableSortedSet subSetImpl(Comparable var1, boolean var2, Comparable var3, boolean var4) {
      return !var2 && !var4 && Range.compareOrThrow(var1, var3) == 0?ImmutableSortedSet.of():this.subSet(Range.range(var1, BoundType.forBoolean(var2), var3, BoundType.forBoolean(var4)));
   }

   ImmutableSortedSet tailSetImpl(Comparable var1, boolean var2) {
      return this.subSet(Range.downTo(var1, BoundType.forBoolean(var2)));
   }

   public boolean contains(@Nullable Object var1) {
      if(var1 == null) {
         return false;
      } else {
         try {
            Comparable var2 = (Comparable)var1;
            return this.this$0.contains(var2);
         } catch (ClassCastException var3) {
            return false;
         }
      }
   }

   int indexOf(Object var1) {
      if(this.contains(var1)) {
         Comparable var2 = (Comparable)var1;
         long var3 = 0L;

         Range var6;
         for(UnmodifiableIterator var5 = ImmutableRangeSet.access$000(this.this$0).iterator(); var5.hasNext(); var3 += (long)ContiguousSet.create(var6, this.domain).size()) {
            var6 = (Range)var5.next();
            if(var6.contains(var2)) {
               return Ints.saturatedCast(var3 + (long)ContiguousSet.create(var6, this.domain).indexOf(var2));
            }
         }

         throw new AssertionError("impossible");
      } else {
         return -1;
      }
   }

   boolean isPartialView() {
      return ImmutableRangeSet.access$000(this.this$0).isPartialView();
   }

   public String toString() {
      return ImmutableRangeSet.access$000(this.this$0).toString();
   }

   Object writeReplace() {
      return new ImmutableRangeSet$AsSetSerializedForm(ImmutableRangeSet.access$000(this.this$0), this.domain);
   }

   // $FF: synthetic method
   static DiscreteDomain access$100(ImmutableRangeSet$AsSet var0) {
      return var0.domain;
   }
}
