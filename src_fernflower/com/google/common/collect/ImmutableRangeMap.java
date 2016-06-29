package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap$1;
import com.google.common.collect.ImmutableRangeMap$2;
import com.google.common.collect.ImmutableRangeMap$Builder;
import com.google.common.collect.ImmutableRangeMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("NavigableMap")
public class ImmutableRangeMap implements RangeMap, Serializable {
   private static final ImmutableRangeMap EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
   private final transient ImmutableList ranges;
   private final transient ImmutableList values;
   private static final long serialVersionUID = 0L;

   public static ImmutableRangeMap of() {
      return EMPTY;
   }

   public static ImmutableRangeMap of(Range var0, Object var1) {
      return new ImmutableRangeMap(ImmutableList.of(var0), ImmutableList.of(var1));
   }

   public static ImmutableRangeMap copyOf(RangeMap var0) {
      if(var0 instanceof ImmutableRangeMap) {
         return (ImmutableRangeMap)var0;
      } else {
         Map var1 = var0.asMapOfRanges();
         ImmutableList$Builder var2 = new ImmutableList$Builder(var1.size());
         ImmutableList$Builder var3 = new ImmutableList$Builder(var1.size());
         Iterator var4 = var1.entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            var2.add(var5.getKey());
            var3.add(var5.getValue());
         }

         return new ImmutableRangeMap(var2.build(), var3.build());
      }
   }

   public static ImmutableRangeMap$Builder builder() {
      return new ImmutableRangeMap$Builder();
   }

   ImmutableRangeMap(ImmutableList var1, ImmutableList var2) {
      this.ranges = var1;
      this.values = var2;
   }

   @Nullable
   public Object get(Comparable var1) {
      int var2 = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), (Comparable)Cut.belowValue(var1), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
      if(var2 == -1) {
         return null;
      } else {
         Range var3 = (Range)this.ranges.get(var2);
         return var3.contains(var1)?this.values.get(var2):null;
      }
   }

   @Nullable
   public Entry getEntry(Comparable var1) {
      int var2 = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), (Comparable)Cut.belowValue(var1), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
      if(var2 == -1) {
         return null;
      } else {
         Range var3 = (Range)this.ranges.get(var2);
         return var3.contains(var1)?Maps.immutableEntry(var3, this.values.get(var2)):null;
      }
   }

   public Range span() {
      if(this.ranges.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         Range var1 = (Range)this.ranges.get(0);
         Range var2 = (Range)this.ranges.get(this.ranges.size() - 1);
         return Range.create(var1.lowerBound, var2.upperBound);
      }
   }

   public void put(Range var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void putAll(RangeMap var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public void remove(Range var1) {
      throw new UnsupportedOperationException();
   }

   public ImmutableMap asMapOfRanges() {
      if(this.ranges.isEmpty()) {
         return ImmutableMap.of();
      } else {
         RegularImmutableSortedSet var1 = new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING);
         return new ImmutableSortedMap(var1, this.values);
      }
   }

   public ImmutableMap asDescendingMapOfRanges() {
      if(this.ranges.isEmpty()) {
         return ImmutableMap.of();
      } else {
         RegularImmutableSortedSet var1 = new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse());
         return new ImmutableSortedMap(var1, this.values.reverse());
      }
   }

   public ImmutableRangeMap subRangeMap(Range var1) {
      if(((Range)Preconditions.checkNotNull(var1)).isEmpty()) {
         return of();
      } else if(!this.ranges.isEmpty() && !var1.encloses(this.span())) {
         int var2 = SortedLists.binarySearch(this.ranges, (Function)Range.upperBoundFn(), (Comparable)var1.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
         int var3 = SortedLists.binarySearch(this.ranges, (Function)Range.lowerBoundFn(), (Comparable)var1.upperBound, SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
         if(var2 >= var3) {
            return of();
         } else {
            int var5 = var3 - var2;
            ImmutableRangeMap$1 var6 = new ImmutableRangeMap$1(this, var5, var2, var1);
            return new ImmutableRangeMap$2(this, var6, this.values.subList(var2, var3), var1, this);
         }
      } else {
         return this;
      }
   }

   public int hashCode() {
      return this.asMapOfRanges().hashCode();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof RangeMap) {
         RangeMap var2 = (RangeMap)var1;
         return this.asMapOfRanges().equals(var2.asMapOfRanges());
      } else {
         return false;
      }
   }

   public String toString() {
      return this.asMapOfRanges().toString();
   }

   Object writeReplace() {
      return new ImmutableRangeMap$SerializedForm(this.asMapOfRanges());
   }

   // $FF: synthetic method
   static ImmutableList access$000(ImmutableRangeMap var0) {
      return var0.ranges;
   }
}
