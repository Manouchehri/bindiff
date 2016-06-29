package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$1;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound$2;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class TreeRangeSet$ComplementRangesByLowerBound extends AbstractNavigableMap {
   private final NavigableMap positiveRangesByLowerBound;
   private final NavigableMap positiveRangesByUpperBound;
   private final Range complementLowerBoundWindow;

   TreeRangeSet$ComplementRangesByLowerBound(NavigableMap var1) {
      this(var1, Range.all());
   }

   private TreeRangeSet$ComplementRangesByLowerBound(NavigableMap var1, Range var2) {
      this.positiveRangesByLowerBound = var1;
      this.positiveRangesByUpperBound = new TreeRangeSet$RangesByUpperBound(var1);
      this.complementLowerBoundWindow = var2;
   }

   private NavigableMap subMap(Range var1) {
      if(!this.complementLowerBoundWindow.isConnected(var1)) {
         return ImmutableSortedMap.of();
      } else {
         var1 = var1.intersection(this.complementLowerBoundWindow);
         return new TreeRangeSet$ComplementRangesByLowerBound(this.positiveRangesByLowerBound, var1);
      }
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

   Iterator entryIterator() {
      Collection var1;
      if(this.complementLowerBoundWindow.hasLowerBound()) {
         var1 = this.positiveRangesByUpperBound.tailMap(this.complementLowerBoundWindow.lowerEndpoint(), this.complementLowerBoundWindow.lowerBoundType() == BoundType.CLOSED).values();
      } else {
         var1 = this.positiveRangesByUpperBound.values();
      }

      PeekingIterator var2 = Iterators.peekingIterator(var1.iterator());
      Cut var3;
      if(this.complementLowerBoundWindow.contains(Cut.belowAll()) && (!var2.hasNext() || ((Range)var2.peek()).lowerBound != Cut.belowAll())) {
         var3 = Cut.belowAll();
      } else {
         if(!var2.hasNext()) {
            return Iterators.emptyIterator();
         }

         var3 = ((Range)var2.next()).upperBound;
      }

      return new TreeRangeSet$ComplementRangesByLowerBound$1(this, var3, var2);
   }

   Iterator descendingEntryIterator() {
      Cut var1 = this.complementLowerBoundWindow.hasUpperBound()?(Cut)this.complementLowerBoundWindow.upperEndpoint():Cut.aboveAll();
      boolean var2 = this.complementLowerBoundWindow.hasUpperBound() && this.complementLowerBoundWindow.upperBoundType() == BoundType.CLOSED;
      PeekingIterator var3 = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(var1, var2).descendingMap().values().iterator());
      Cut var4;
      if(var3.hasNext()) {
         var4 = ((Range)var3.peek()).upperBound == Cut.aboveAll()?((Range)var3.next()).lowerBound:(Cut)this.positiveRangesByLowerBound.higherKey(((Range)var3.peek()).upperBound);
      } else {
         if(!this.complementLowerBoundWindow.contains(Cut.belowAll()) || this.positiveRangesByLowerBound.containsKey(Cut.belowAll())) {
            return Iterators.emptyIterator();
         }

         var4 = (Cut)this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
      }

      Cut var5 = (Cut)MoreObjects.firstNonNull(var4, Cut.aboveAll());
      return new TreeRangeSet$ComplementRangesByLowerBound$2(this, var5, var3);
   }

   public int size() {
      return Iterators.size(this.entryIterator());
   }

   @Nullable
   public Range get(Object var1) {
      if(var1 instanceof Cut) {
         try {
            Cut var2 = (Cut)var1;
            Entry var3 = this.tailMap(var2, true).firstEntry();
            if(var3 != null && ((Cut)var3.getKey()).equals(var2)) {
               return (Range)var3.getValue();
            }
         } catch (ClassCastException var4) {
            return null;
         }
      }

      return null;
   }

   public boolean containsKey(Object var1) {
      return this.get(var1) != null;
   }

   // $FF: synthetic method
   static Range access$100(TreeRangeSet$ComplementRangesByLowerBound var0) {
      return var0.complementLowerBoundWindow;
   }
}
