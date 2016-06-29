package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import java.io.Serializable;

final class DiscreteDomain$LongDomain extends DiscreteDomain implements Serializable {
   private static final DiscreteDomain$LongDomain INSTANCE = new DiscreteDomain$LongDomain();
   private static final long serialVersionUID = 0L;

   public Long next(Long var1) {
      long var2 = var1.longValue();
      return var2 == Long.MAX_VALUE?null:Long.valueOf(var2 + 1L);
   }

   public Long previous(Long var1) {
      long var2 = var1.longValue();
      return var2 == Long.MIN_VALUE?null:Long.valueOf(var2 - 1L);
   }

   public long distance(Long var1, Long var2) {
      long var3 = var2.longValue() - var1.longValue();
      return var2.longValue() > var1.longValue() && var3 < 0L?Long.MAX_VALUE:(var2.longValue() < var1.longValue() && var3 > 0L?Long.MIN_VALUE:var3);
   }

   public Long minValue() {
      return Long.valueOf(Long.MIN_VALUE);
   }

   public Long maxValue() {
      return Long.valueOf(Long.MAX_VALUE);
   }

   private Object readResolve() {
      return INSTANCE;
   }

   public String toString() {
      return "DiscreteDomain.longs()";
   }

   // $FF: synthetic method
   static DiscreteDomain$LongDomain access$100() {
      return INSTANCE;
   }
}
