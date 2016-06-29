package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

enum Funnels$UnencodedCharsFunnel implements Funnel {
   INSTANCE;

   public void funnel(CharSequence var1, PrimitiveSink var2) {
      var2.putUnencodedChars(var1);
   }

   public String toString() {
      return "Funnels.unencodedCharsFunnel()";
   }
}
