package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound$1;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound$2;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@VisibleForTesting
final class TreeRangeSet$RangesByUpperBound extends AbstractNavigableMap {
   private final NavigableMap rangesByLowerBound;
   private final Range upperBoundWindow;

   TreeRangeSet$RangesByUpperBound(NavigableMap var1) {
      this.rangesByLowerBound = var1;
      this.upperBoundWindow = Range.all();
   }

   private TreeRangeSet$RangesByUpperBound(NavigableMap var1, Range var2) {
      this.rangesByLowerBound = var1;
      this.upperBoundWindow = var2;
   }

   private NavigableMap subMap(Range var1) {
      return (NavigableMap)(var1.isConnected(this.upperBoundWindow)?new TreeRangeSet$RangesByUpperBound(this.rangesByLowerBound, var1.intersection(this.upperBoundWindow)):ImmutableSortedMap.of());
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

   public Range get(@Nullable Object var1) {
      if(var1 instanceof Cut) {
         try {
            Cut var2 = (Cut)var1;
            if(!this.upperBoundWindow.contains(var2)) {
               return null;
            }

            Entry var3 = this.rangesByLowerBound.lowerEntry(var2);
            if(var3 != null && ((Range)var3.getValue()).upperBound.equals(var2)) {
               return (Range)var3.getValue();
            }
         } catch (ClassCastException var4) {
            return null;
         }
      }

      return null;
   }

   Iterator entryIterator() {
      Iterator var1;
      if(!this.upperBoundWindow.hasLowerBound()) {
         var1 = this.rangesByLowerBound.values().iterator();
      } else {
         Entry var2 = this.rangesByLowerBound.lowerEntry(this.upperBoundWindow.lowerEndpoint());
         if(var2 == null) {
            var1 = this.rangesByLowerBound.values().iterator();
         } else if(this.upperBoundWindow.lowerBound.isLessThan(((Range)var2.getValue()).upperBound)) {
            var1 = this.rangesByLowerBound.tailMap(var2.getKey(), true).values().iterator();
         } else {
            var1 = this.rangesByLowerBound.tailMap(this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
         }
      }

      return new TreeRangeSet$RangesByUpperBound$1(this, var1);
   }

   Iterator descendingEntryIterator() {
      Collection var1;
      if(this.upperBoundWindow.hasUpperBound()) {
         var1 = this.rangesByLowerBound.headMap(this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();
      } else {
         var1 = this.rangesByLowerBound.descendingMap().values();
      }

      PeekingIterator var2 = Iterators.peekingIterator(var1.iterator());
      if(var2.hasNext() && this.upperBoundWindow.upperBound.isLessThan(((Range)var2.peek()).upperBound)) {
         var2.next();
      }

      return new TreeRangeSet$RangesByUpperBound$2(this, var2);
   }

   public int size() {
      return this.upperBoundWindow.equals(Range.all())?this.rangesByLowerBound.size():Iterators.size(this.entryIterator());
   }

   public boolean isEmpty() {
      return this.upperBoundWindow.equals(Range.all())?this.rangesByLowerBound.isEmpty():!this.entryIterator().hasNext();
   }

   // $FF: synthetic method
   static Range access$000(TreeRangeSet$RangesByUpperBound var0) {
      return var0.upperBoundWindow;
   }
}
