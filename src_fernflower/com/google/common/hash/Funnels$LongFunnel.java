package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$LongFunnel implements Funnel {
   INSTANCE;

   public void funnel(Long var1, PrimitiveSink var2) {
      var2.putLong(var1.longValue());
   }

   public String toString() {
      return "Funnels.longFunnel()";
   }
}
