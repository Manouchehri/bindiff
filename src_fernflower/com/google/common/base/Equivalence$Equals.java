package com.google.common.base;

import com.google.common.base.Equivalence;
import java.io.Serializable;

final class Equivalence$Equals extends Equivalence implements Serializable {
   static final Equivalence$Equals INSTANCE = new Equivalence$Equals();
   private static final long serialVersionUID = 1L;

   protected boolean doEquivalent(Object var1, Object var2) {
      return var1.equals(var2);
   }

   protected int doHash(Object var1) {
      return var1.hashCode();
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
