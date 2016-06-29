package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut$AboveAll;
import com.google.common.collect.Cut$AboveValue;
import com.google.common.collect.Cut$BelowAll;
import com.google.common.collect.Cut$BelowValue;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
abstract class Cut implements Serializable, Comparable {
   final Comparable endpoint;
   private static final long serialVersionUID = 0L;

   Cut(@Nullable Comparable var1) {
      this.endpoint = var1;
   }

   abstract boolean isLessThan(Comparable var1);

   abstract BoundType typeAsLowerBound();

   abstract BoundType typeAsUpperBound();

   abstract Cut withLowerBoundType(BoundType var1, DiscreteDomain var2);

   abstract Cut withUpperBoundType(BoundType var1, DiscreteDomain var2);

   abstract void describeAsLowerBound(StringBuilder var1);

   abstract void describeAsUpperBound(StringBuilder var1);

   abstract Comparable leastValueAbove(DiscreteDomain var1);

   abstract Comparable greatestValueBelow(DiscreteDomain var1);

   Cut canonical(DiscreteDomain var1) {
      return this;
   }

   public int compareTo(Cut var1) {
      if(var1 == belowAll()) {
         return 1;
      } else if(var1 == aboveAll()) {
         return -1;
      } else {
         int var2 = Range.compareOrThrow(this.endpoint, var1.endpoint);
         return var2 != 0?var2:Booleans.compare(this instanceof Cut$AboveValue, var1 instanceof Cut$AboveValue);
      }
   }

   Comparable endpoint() {
      return this.endpoint;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Cut) {
         Cut var2 = (Cut)var1;

         try {
            int var3 = this.compareTo(var2);
            return var3 == 0;
         } catch (ClassCastException var4) {
            ;
         }
      }

      return false;
   }

   static Cut belowAll() {
      return Cut$BelowAll.access$000();
   }

   static Cut aboveAll() {
      return Cut$AboveAll.access$100();
   }

   static Cut belowValue(Comparable var0) {
      return new Cut$BelowValue(var0);
   }

   static Cut aboveValue(Comparable var0) {
      return new Cut$AboveValue(var0);
   }
}
