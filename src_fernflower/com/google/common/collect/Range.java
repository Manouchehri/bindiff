package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range$1;
import com.google.common.collect.Range$2;
import com.google.common.collect.Range$3;
import com.google.common.collect.Range$RangeLexOrdering;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public final class Range implements Predicate, Serializable {
   private static final Function LOWER_BOUND_FN = new Range$1();
   private static final Function UPPER_BOUND_FN = new Range$2();
   static final Ordering RANGE_LEX_ORDERING = new Range$RangeLexOrdering((Range$1)null);
   private static final Range ALL = new Range(Cut.belowAll(), Cut.aboveAll());
   final Cut lowerBound;
   final Cut upperBound;
   private static final long serialVersionUID = 0L;

   static Function lowerBoundFn() {
      return LOWER_BOUND_FN;
   }

   static Function upperBoundFn() {
      return UPPER_BOUND_FN;
   }

   static Range create(Cut var0, Cut var1) {
      return new Range(var0, var1);
   }

   public static Range open(Comparable var0, Comparable var1) {
      return create(Cut.aboveValue(var0), Cut.belowValue(var1));
   }

   public static Range closed(Comparable var0, Comparable var1) {
      return create(Cut.belowValue(var0), Cut.aboveValue(var1));
   }

   @Deprecated
   @GoogleInternal
   public static Range closedOrEmpty(Comparable var0, Comparable var1) {
      return var0.compareTo(var1) > 0?closedOpen(var0, var0):closed(var0, var1);
   }

   public static Range closedOpen(Comparable var0, Comparable var1) {
      return create(Cut.belowValue(var0), Cut.belowValue(var1));
   }

   public static Range openClosed(Comparable var0, Comparable var1) {
      return create(Cut.aboveValue(var0), Cut.aboveValue(var1));
   }

   public static Range range(Comparable var0, BoundType var1, Comparable var2, BoundType var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);
      Cut var4 = var1 == BoundType.OPEN?Cut.aboveValue(var0):Cut.belowValue(var0);
      Cut var5 = var3 == BoundType.OPEN?Cut.belowValue(var2):Cut.aboveValue(var2);
      return create(var4, var5);
   }

   public static Range lessThan(Comparable var0) {
      return create(Cut.belowAll(), Cut.belowValue(var0));
   }

   public static Range atMost(Comparable var0) {
      return create(Cut.belowAll(), Cut.aboveValue(var0));
   }

   public static Range upTo(Comparable var0, BoundType var1) {
      switch(Range$3.$SwitchMap$com$google$common$collect$BoundType[var1.ordinal()]) {
      case 1:
         return lessThan(var0);
      case 2:
         return atMost(var0);
      default:
         throw new AssertionError();
      }
   }

   public static Range greaterThan(Comparable var0) {
      return create(Cut.aboveValue(var0), Cut.aboveAll());
   }

   public static Range atLeast(Comparable var0) {
      return create(Cut.belowValue(var0), Cut.aboveAll());
   }

   public static Range downTo(Comparable var0, BoundType var1) {
      switch(Range$3.$SwitchMap$com$google$common$collect$BoundType[var1.ordinal()]) {
      case 1:
         return greaterThan(var0);
      case 2:
         return atLeast(var0);
      default:
         throw new AssertionError();
      }
   }

   public static Range all() {
      return ALL;
   }

   public static Range singleton(Comparable var0) {
      return closed(var0, var0);
   }

   public static Range encloseAll(Iterable var0) {
      Preconditions.checkNotNull(var0);
      if(var0 instanceof ContiguousSet) {
         return ((ContiguousSet)var0).range();
      } else {
         Iterator var1 = var0.iterator();
         Comparable var2 = (Comparable)Preconditions.checkNotNull(var1.next());

         Comparable var3;
         Comparable var4;
         for(var3 = var2; var1.hasNext(); var3 = (Comparable)Ordering.natural().max(var3, var4)) {
            var4 = (Comparable)Preconditions.checkNotNull(var1.next());
            var2 = (Comparable)Ordering.natural().min(var2, var4);
         }

         return closed(var2, var3);
      }
   }

   private Range(Cut var1, Cut var2) {
      // $FF: Couldn't be decompiled
   }

   public boolean hasLowerBound() {
      return this.lowerBound != Cut.belowAll();
   }

   public Comparable lowerEndpoint() {
      return this.lowerBound.endpoint();
   }

   public BoundType lowerBoundType() {
      return this.lowerBound.typeAsLowerBound();
   }

   public boolean hasUpperBound() {
      return this.upperBound != Cut.aboveAll();
   }

   public Comparable upperEndpoint() {
      return this.upperBound.endpoint();
   }

   public BoundType upperBoundType() {
      return this.upperBound.typeAsUpperBound();
   }

   public boolean isEmpty() {
      return this.lowerBound.equals(this.upperBound);
   }

   public boolean contains(Comparable var1) {
      Preconditions.checkNotNull(var1);
      return this.lowerBound.isLessThan(var1) && !this.upperBound.isLessThan(var1);
   }

   @Deprecated
   public boolean apply(Comparable var1) {
      return this.contains(var1);
   }

   public boolean containsAll(Iterable var1) {
      if(Iterables.isEmpty(var1)) {
         return true;
      } else {
         if(var1 instanceof SortedSet) {
            SortedSet var2 = cast(var1);
            Comparator var3 = var2.comparator();
            if(Ordering.natural().equals(var3) || var3 == null) {
               return this.contains((Comparable)var2.first()) && this.contains((Comparable)var2.last());
            }
         }

         Iterator var4 = var1.iterator();

         Comparable var5;
         do {
            if(!var4.hasNext()) {
               return true;
            }

            var5 = (Comparable)var4.next();
         } while(this.contains(var5));

         return false;
      }
   }

   public boolean encloses(Range var1) {
      return this.lowerBound.compareTo(var1.lowerBound) <= 0 && this.upperBound.compareTo(var1.upperBound) >= 0;
   }

   public boolean isConnected(Range var1) {
      return this.lowerBound.compareTo(var1.upperBound) <= 0 && var1.lowerBound.compareTo(this.upperBound) <= 0;
   }

   public Range intersection(Range var1) {
      int var2 = this.lowerBound.compareTo(var1.lowerBound);
      int var3 = this.upperBound.compareTo(var1.upperBound);
      if(var2 >= 0 && var3 <= 0) {
         return this;
      } else if(var2 <= 0 && var3 >= 0) {
         return var1;
      } else {
         Cut var4 = var2 >= 0?this.lowerBound:var1.lowerBound;
         Cut var5 = var3 <= 0?this.upperBound:var1.upperBound;
         return create(var4, var5);
      }
   }

   public Range span(Range var1) {
      int var2 = this.lowerBound.compareTo(var1.lowerBound);
      int var3 = this.upperBound.compareTo(var1.upperBound);
      if(var2 <= 0 && var3 >= 0) {
         return this;
      } else if(var2 >= 0 && var3 <= 0) {
         return var1;
      } else {
         Cut var4 = var2 <= 0?this.lowerBound:var1.lowerBound;
         Cut var5 = var3 >= 0?this.upperBound:var1.upperBound;
         return create(var4, var5);
      }
   }

   public Range canonical(DiscreteDomain var1) {
      Preconditions.checkNotNull(var1);
      Cut var2 = this.lowerBound.canonical(var1);
      Cut var3 = this.upperBound.canonical(var1);
      return var2 == this.lowerBound && var3 == this.upperBound?this:create(var2, var3);
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Range)) {
         return false;
      } else {
         Range var2 = (Range)var1;
         return this.lowerBound.equals(var2.lowerBound) && this.upperBound.equals(var2.upperBound);
      }
   }

   public int hashCode() {
      return this.lowerBound.hashCode() * 31 + this.upperBound.hashCode();
   }

   public String toString() {
      return toString(this.lowerBound, this.upperBound);
   }

   private static String toString(Cut var0, Cut var1) {
      StringBuilder var2 = new StringBuilder(16);
      var0.describeAsLowerBound(var2);
      var2.append('‥');
      var1.describeAsUpperBound(var2);
      return var2.toString();
   }

   private static SortedSet cast(Iterable var0) {
      return (SortedSet)var0;
   }

   Object readResolve() {
      return this.equals(ALL)?all():this;
   }

   static int compareOrThrow(Comparable var0, Comparable var1) {
      return var0.compareTo(var1);
   }
}
