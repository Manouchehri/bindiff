package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

class Funnels$SequentialFunnel implements Funnel, Serializable {
   private final Funnel elementFunnel;

   Funnels$SequentialFunnel(Funnel var1) {
      this.elementFunnel = (Funnel)Preconditions.checkNotNull(var1);
   }

   public void funnel(Iterable var1, PrimitiveSink var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         this.elementFunnel.funnel(var4, var2);
      }

   }

   public String toString() {
      String var1 = String.valueOf(this.elementFunnel);
      return (new StringBuilder(26 + String.valueOf(var1).length())).append("Funnels.sequentialFunnel(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Funnels$SequentialFunnel) {
         Funnels$SequentialFunnel var2 = (Funnels$SequentialFunnel)var1;
         return this.elementFunnel.equals(var2.elementFunnel);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Funnels$SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
   }
}
