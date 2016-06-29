package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;

final class Cut$AboveAll extends Cut {
   private static final Cut$AboveAll INSTANCE = new Cut$AboveAll();
   private static final long serialVersionUID = 0L;

   private Cut$AboveAll() {
      super((Comparable)null);
   }

   Comparable endpoint() {
      throw new IllegalStateException("range unbounded on this side");
   }

   boolean isLessThan(Comparable var1) {
      return false;
   }

   BoundType typeAsLowerBound() {
      throw new AssertionError("this statement should be unreachable");
   }

   BoundType typeAsUpperBound() {
      throw new IllegalStateException();
   }

   Cut withLowerBoundType(BoundType var1, DiscreteDomain var2) {
      throw new AssertionError("this statement should be unreachable");
   }

   Cut withUpperBoundType(BoundType var1, DiscreteDomain var2) {
      throw new IllegalStateException();
   }

   void describeAsLowerBound(StringBuilder var1) {
      throw new AssertionError();
   }

   void describeAsUpperBound(StringBuilder var1) {
      var1.append("+∞)");
   }

   Comparable leastValueAbove(DiscreteDomain var1) {
      throw new AssertionError();
   }

   Comparable greatestValueBelow(DiscreteDomain var1) {
      return var1.maxValue();
   }

   public int compareTo(Cut var1) {
      return var1 == this?0:1;
   }

   public String toString() {
      return "+∞";
   }

   private Object readResolve() {
      return INSTANCE;
   }

   // $FF: synthetic method
   static Cut$AboveAll access$100() {
      return INSTANCE;
   }
}
