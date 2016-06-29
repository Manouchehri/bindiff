package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import java.util.NoSuchElementException;

final class Cut$BelowAll extends Cut {
   private static final Cut$BelowAll INSTANCE = new Cut$BelowAll();
   private static final long serialVersionUID = 0L;

   private Cut$BelowAll() {
      super((Comparable)null);
   }

   Comparable endpoint() {
      throw new IllegalStateException("range unbounded on this side");
   }

   boolean isLessThan(Comparable var1) {
      return true;
   }

   BoundType typeAsLowerBound() {
      throw new IllegalStateException();
   }

   BoundType typeAsUpperBound() {
      throw new AssertionError("this statement should be unreachable");
   }

   Cut withLowerBoundType(BoundType var1, DiscreteDomain var2) {
      throw new IllegalStateException();
   }

   Cut withUpperBoundType(BoundType var1, DiscreteDomain var2) {
      throw new AssertionError("this statement should be unreachable");
   }

   void describeAsLowerBound(StringBuilder var1) {
      var1.append("(-∞");
   }

   void describeAsUpperBound(StringBuilder var1) {
      throw new AssertionError();
   }

   Comparable leastValueAbove(DiscreteDomain var1) {
      return var1.minValue();
   }

   Comparable greatestValueBelow(DiscreteDomain var1) {
      throw new AssertionError();
   }

   Cut canonical(DiscreteDomain var1) {
      try {
         return Cut.belowValue(var1.minValue());
      } catch (NoSuchElementException var3) {
         return this;
      }
   }

   public int compareTo(Cut var1) {
      return var1 == this?0:-1;
   }

   public String toString() {
      return "-∞";
   }

   private Object readResolve() {
      return INSTANCE;
   }

   // $FF: synthetic method
   static Cut$BelowAll access$000() {
      return INSTANCE;
   }
}
