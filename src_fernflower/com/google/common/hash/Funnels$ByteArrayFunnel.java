package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$ByteArrayFunnel implements Funnel {
   INSTANCE;

   public void funnel(byte[] var1, PrimitiveSink var2) {
      var2.putBytes(var1);
   }

   public String toString() {
      return "Funnels.byteArrayFunnel()";
   }
}
