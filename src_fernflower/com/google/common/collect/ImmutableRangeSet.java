package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet$1;
import com.google.common.collect.ImmutableRangeSet$AsSet;
import com.google.common.collect.ImmutableRangeSet$Builder;
import com.google.common.collect.ImmutableRangeSet$ComplementRanges;
import com.google.common.collect.ImmutableRangeSet$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.NoSuchElementException;

@Beta
public final class ImmutableRangeSet extends AbstractRangeSet implements Serializable {
   private static final ImmutableRangeSet EMPTY = new ImmutableRangeSet(ImmutableList.of());
   private static final ImmutableRangeSet ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
   private final transient ImmutableList ranges;
   @LazyInit
   private transient ImmutableRangeSet complement;

   public static ImmutableRangeSet of() {
      return EMPTY;
   }

   static ImmutableRangeSet all() {
      return ALL;
   }

   public static ImmutableRangeSet of(Range var0) {
      Preconditions.checkNotNull(var0);
      return var0.isEmpty()?of():(var0.equals(Range.all())?all():new ImmutableRangeSet(ImmutableList.of(var0)));
   }

   public static ImmutableRangeSet copyOf(RangeSet var0) {
      Preconditions.checkNotNull(var0);
      if(var0.isEmpty()) {
         return of();
      } else if(var0.encloses(Range.all())) {
         return all();
      } else {
         if(var0 instanceof ImmutableRangeSet) {
            ImmutableRangeSet var1 = (ImmutableRangeSet)var0;
            if(!var1.isPartialView()) {
               return var1;
            }
         }

         return new ImmutableRangeSet(ImmutableList.copyOf((Collection)var0.asRanges()));
      }
   }

   ImmutableRangeSet(ImmutableList var1) {
      this.ranges = var1;
   }

   private ImmutableRangeSet(ImmutableList var1, ImmutableRangeSet var2) {
      this.ranges = var1;
      this.complement = var2;
   }

   public boolean encloses(Range var1) {
      int var2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), var1.lowerBound, Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
      return var2 != -1 && ((Range)this.ranges.get(var2)).encloses(var1);
   }

   public Range rangeContaining(Comparable var1) {
      int var2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(var1), Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
      if(var2 != -1) {
         Range var3 = (Range)this.ranges.get(var2);
         return var3.contains(var1)?var3:null;
      } else {
         return null;
      }
   }

   public Range span() {
      if(this.ranges.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return Range.create(((Range)this.ranges.get(0)).lowerBound, ((Range)this.ranges.get(this.ranges.size() - 1)).upperBound);
      }
   }

   public boolean isEmpty() {
      return this.ranges.isEmpty();
   }

   public void add(Range var1) {
      throw new UnsupportedOperationException();
   }

   public void addAll(RangeSet var1) {
      throw new UnsupportedOperationException();
   }

   public void remove(Range var1) {
      throw new UnsupportedOperationException();
   }

   public void removeAll(RangeSet var1) {
      throw new UnsupportedOperationException();
   }

   public ImmutableSet asRanges() {
      return (ImmutableSet)(this.ranges.isEmpty()?ImmutableSet.of():new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING));
   }

   public ImmutableSet asDescendingSetOfRanges() {
      return (ImmutableSet)(this.ranges.isEmpty()?ImmutableSet.of():new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse()));
   }

   public ImmutableRangeSet complement() {
      ImmutableRangeSet var1 = this.complement;
      if(var1 != null) {
         return var1;
      } else if(this.ranges.isEmpty()) {
         return this.complement = all();
      } else if(this.ranges.size() == 1 && ((Range)this.ranges.get(0)).equals(Range.all())) {
         return this.complement = of();
      } else {
         ImmutableRangeSet$ComplementRanges var2 = new ImmutableRangeSet$ComplementRanges(this);
         var1 = this.complement = new ImmutableRangeSet(var2, this);
         return var1;
      }
   }

   private ImmutableList intersectRanges(Range var1) {
      if(!this.ranges.isEmpty() && !var1.isEmpty()) {
         if(var1.encloses(this.span())) {
            return this.ranges;
         } else {
            int var2;
            if(var1.hasLowerBound()) {
               var2 = SortedLists.binarySearch(this.ranges, (Function)Range.upperBoundFn(), (Comparable)var1.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
            } else {
               var2 = 0;
            }

            int var3;
            if(var1.hasUpperBound()) {
               var3 = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), (Comparable)var1.upperBound, SortedLists$KeyPresentBehavior.FIRST_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
            } else {
               var3 = this.ranges.size();
            }

            int var4 = var3 - var2;
            return (ImmutableList)(var4 == 0?ImmutableList.of():new ImmutableRangeSet$1(this, var4, var2, var1));
         }
      } else {
         return ImmutableList.of();
      }
   }

   public ImmutableRangeSet subRangeSet(Range var1) {
      if(!this.isEmpty()) {
         Range var2 = this.span();
         if(var1.encloses(var2)) {
            return this;
         }

         if(var1.isConnected(var2)) {
            return new ImmutableRangeSet(this.intersectRanges(var1));
         }
      }

      return of();
   }

   public ImmutableSortedSet asSet(DiscreteDomain var1) {
      Preconditions.checkNotNull(var1);
      if(this.isEmpty()) {
         return ImmutableSortedSet.of();
      } else {
         Range var2 = this.span().canonical(var1);
         if(!var2.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
         } else {
            if(!var2.hasUpperBound()) {
               try {
                  var1.maxValue();
               } catch (NoSuchElementException var4) {
                  throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
               }
            }

            return new ImmutableRangeSet$AsSet(this, var1);
         }
      }
   }

   boolean isPartialView() {
      return this.ranges.isPartialView();
   }

   public static ImmutableRangeSet$Builder builder() {
      return new ImmutableRangeSet$Builder();
   }

   Object writeReplace() {
      return new ImmutableRangeSet$SerializedForm(this.ranges);
   }

   // $FF: synthetic method
   static ImmutableList access$000(ImmutableRangeSet var0) {
      return var0.ranges;
   }
}
