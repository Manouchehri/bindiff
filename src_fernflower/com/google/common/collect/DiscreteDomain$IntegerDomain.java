package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

final class DiscreteDomain$IntegerDomain extends DiscreteDomain implements Serializable {
   private static final DiscreteDomain$IntegerDomain INSTANCE = new DiscreteDomain$IntegerDomain();
   private static final long serialVersionUID = 0L;

   public Integer next(Integer var1) {
      int var2 = var1.intValue();
      return var2 == Integer.MAX_VALUE?null:Integer.valueOf(var2 + 1);
   }

   public Integer previous(Integer var1) {
      int var2 = var1.intValue();
      return var2 == Integer.MIN_VALUE?null:Integer.valueOf(var2 - 1);
   }

   public long distance(Integer var1, Integer var2) {
      return (long)var2.intValue() - (long)var1.intValue();
   }

   public Integer minValue() {
      return Integer.valueOf(Integer.MIN_VALUE);
   }

   public Integer maxValue() {
      return Integer.valueOf(Integer.MAX_VALUE);
   }

   private Object readResolve() {
      return INSTANCE;
   }

   public String toString() {
      return "DiscreteDomain.integers()";
   }

   // $FF: synthetic method
   static DiscreteDomain$IntegerDomain access$000() {
      return INSTANCE;
   }
}
