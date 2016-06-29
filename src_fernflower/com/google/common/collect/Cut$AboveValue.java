package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.Cut$1;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

final class Cut$AboveValue extends Cut {
   private static final long serialVersionUID = 0L;

   Cut$AboveValue(Comparable var1) {
      super((Comparable)Preconditions.checkNotNull(var1));
   }

   boolean isLessThan(Comparable var1) {
      return Range.compareOrThrow(this.endpoint, var1) < 0;
   }

   BoundType typeAsLowerBound() {
      return BoundType.OPEN;
   }

   BoundType typeAsUpperBound() {
      return BoundType.CLOSED;
   }

   Cut withLowerBoundType(BoundType var1, DiscreteDomain var2) {
      switch(Cut$1.$SwitchMap$com$google$common$collect$BoundType[var1.ordinal()]) {
      case 1:
         Comparable var3 = var2.next(this.endpoint);
         return var3 == null?Cut.belowAll():belowValue(var3);
      case 2:
         return this;
      default:
         throw new AssertionError();
      }
   }

   Cut withUpperBoundType(BoundType var1, DiscreteDomain var2) {
      switch(Cut$1.$SwitchMap$com$google$common$collect$BoundType[var1.ordinal()]) {
      case 1:
         return this;
      case 2:
         Comparable var3 = var2.next(this.endpoint);
         return var3 == null?Cut.aboveAll():belowValue(var3);
      default:
         throw new AssertionError();
      }
   }

   void describeAsLowerBound(StringBuilder var1) {
      var1.append('(').append(this.endpoint);
   }

   void describeAsUpperBound(StringBuilder var1) {
      var1.append(this.endpoint).append(']');
   }

   Comparable leastValueAbove(DiscreteDomain var1) {
      return var1.next(this.endpoint);
   }

   Comparable greatestValueBelow(DiscreteDomain var1) {
      return this.endpoint;
   }

   Cut canonical(DiscreteDomain var1) {
      Comparable var2 = this.leastValueAbove(var1);
      return var2 != null?belowValue(var2):Cut.aboveAll();
   }

   public int hashCode() {
      return ~this.endpoint.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.endpoint);
      return (new StringBuilder(2 + String.valueOf(var1).length())).append("/").append(var1).append("\\").toString();
   }
}
