package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$1;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound$2;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;
import javax.annotation.Nullable;

final class TreeRangeSet$SubRangeSetRangesByLowerBound extends AbstractNavigableMap {
   private final Range lowerBoundWindow;
   private final Range restriction;
   private final NavigableMap rangesByLowerBound;
   private final NavigableMap rangesByUpperBound;

   private TreeRangeSet$SubRangeSetRangesByLowerBound(Range var1, Range var2, NavigableMap var3) {
      this.lowerBoundWindow = (Range)Preconditions.checkNotNull(var1);
      this.restriction = (Range)Preconditions.checkNotNull(var2);
      this.rangesByLowerBound = (NavigableMap)Preconditions.checkNotNull(var3);
      this.rangesByUpperBound = new TreeRangeSet$RangesByUpperBound(var3);
   }

   private NavigableMap subMap(Range var1) {
      return (NavigableMap)(!var1.isConnected(this.lowerBoundWindow)?ImmutableSortedMap.of():new TreeRangeSet$SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(var1), this.restriction, this.rangesByLowerBound));
   }

   public NavigableMap subMap(Cut var1, boolean var2, Cut var3, boolean var4) {
      return this.subMap(Range.range(var1, BoundType.forBoolean(var2), var3, BoundType.forBoolean(var4)));
   }

   public NavigableMap headMap(Cut var1, boolean var2) {
      return this.subMap(Range.upTo(var1, BoundType.forBoolean(var2)));
   }

   public NavigableMap tailMap(Cut var1, boolean var2) {
      return this.subMap(Range.downTo(var1, BoundType.forBoolean(var2)));
   }

   public Comparator comparator() {
      return Ordering.natural();
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.get(var1) != null;
   }

   @Nullable
   public Range get(@Nullable Object var1) {
      if(var1 instanceof Cut) {
         try {
            Cut var2 = (Cut)var1;
            if(!this.lowerBoundWindow.contains(var2) || var2.compareTo(this.restriction.lowerBound) < 0 || var2.compareTo(this.restriction.upperBound) >= 0) {
               return null;
            }

            Range var3;
            if(var2.equals(this.restriction.lowerBound)) {
               var3 = (Range)Maps.valueOrNull(this.rangesByLowerBound.floorEntry(var2));
               if(var3 != null && var3.upperBound.compareTo(this.restriction.lowerBound) > 0) {
                  return var3.intersection(this.restriction);
               }
            } else {
               var3 = (Range)this.rangesByLowerBound.get(var2);
               if(var3 != null) {
                  return var3.intersection(this.restriction);
               }
            }
         } catch (ClassCastException var4) {
            return null;
         }
      }

      return null;
   }

   Iterator entryIterator() {
      if(this.restriction.isEmpty()) {
         return Iterators.emptyIterator();
      } else if(this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound)) {
         return Iterators.emptyIterator();
      } else {
         Iterator var1;
         if(this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound)) {
            var1 = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();
         } else {
            var1 = this.rangesByLowerBound.tailMap(this.lowerBoundWindow.lowerBound.endpoint(), this.lowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values().iterator();
         }

         Cut var2 = (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
         return new TreeRangeSet$SubRangeSetRangesByLowerBound$1(this, var1, var2);
      }
   }

   Iterator descendingEntryIterator() {
      if(this.restriction.isEmpty()) {
         return Iterators.emptyIterator();
      } else {
         Cut var1 = (Cut)Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
         Iterator var2 = this.rangesByLowerBound.headMap(var1.endpoint(), var1.typeAsUpperBound() == BoundType.CLOSED).descendingMap().values().iterator();
         return new TreeRangeSet$SubRangeSetRangesByLowerBound$2(this, var2);
      }
   }

   public int size() {
      return Iterators.size(this.entryIterator());
   }

   // $FF: synthetic method
   static Range access$300(TreeRangeSet$SubRangeSetRangesByLowerBound var0) {
      return var0.restriction;
   }

   // $FF: synthetic method
   static Range access$400(TreeRangeSet$SubRangeSetRangesByLowerBound var0) {
      return var0.lowerBoundWindow;
   }

   // $FF: synthetic method
   TreeRangeSet$SubRangeSetRangesByLowerBound(Range var1, Range var2, NavigableMap var3, TreeRangeSet$1 var4) {
      this(var1, var2, var3);
   }
}
