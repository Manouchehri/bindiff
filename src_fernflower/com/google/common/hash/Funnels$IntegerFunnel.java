package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$IntegerFunnel implements Funnel {
   INSTANCE;

   public void funnel(Integer var1, PrimitiveSink var2) {
      var2.putInt(var1.intValue());
   }

   public String toString() {
      return "Funnels.integerFunnel()";
   }
}
