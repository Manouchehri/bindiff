package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.Cut$1;
import com.google.common.collect.Cut$AboveValue;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

final class Cut$BelowValue extends Cut {
   private static final long serialVersionUID = 0L;

   Cut$BelowValue(Comparable var1) {
      super((Comparable)Preconditions.checkNotNull(var1));
   }

   boolean isLessThan(Comparable var1) {
      return Range.compareOrThrow(this.endpoint, var1) <= 0;
   }

   BoundType typeAsLowerBound() {
      return BoundType.CLOSED;
   }

   BoundType typeAsUpperBound() {
      return BoundType.OPEN;
   }

   Cut withLowerBoundType(BoundType var1, DiscreteDomain var2) {
      switch(Cut$1.$SwitchMap$com$google$common$collect$BoundType[var1.ordinal()]) {
      case 1:
         return this;
      case 2:
         Comparable var3 = var2.previous(this.endpoint);
         return (Cut)(var3 == null?Cut.belowAll():new Cut$AboveValue(var3));
      default:
         throw new AssertionError();
      }
   }

   Cut withUpperBoundType(BoundType var1, DiscreteDomain var2) {
      switch(Cut$1.$SwitchMap$com$google$common$collect$BoundType[var1.ordinal()]) {
      case 1:
         Comparable var3 = var2.previous(this.endpoint);
         return (Cut)(var3 == null?Cut.aboveAll():new Cut$AboveValue(var3));
      case 2:
         return this;
      default:
         throw new AssertionError();
      }
   }

   void describeAsLowerBound(StringBuilder var1) {
      var1.append('[').append(this.endpoint);
   }

   void describeAsUpperBound(StringBuilder var1) {
      var1.append(this.endpoint).append(')');
   }

   Comparable leastValueAbove(DiscreteDomain var1) {
      return this.endpoint;
   }

   Comparable greatestValueBelow(DiscreteDomain var1) {
      return var1.previous(this.endpoint);
   }

   public int hashCode() {
      return this.endpoint.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.endpoint);
      return (new StringBuilder(2 + String.valueOf(var1).length())).append("\\").append(var1).append("/").toString();
   }
}
