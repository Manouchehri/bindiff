package com.google.security.zynamics.zylib.general;

import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PairHelpers {
   public static List projectFirst(List var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         var1.add(var3.first());
      }

      return var1;
   }

   public static List projectSecond(List var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Pair var3 = (Pair)var2.next();
         var1.add(var3.second());
      }

      return var1;
   }
}
