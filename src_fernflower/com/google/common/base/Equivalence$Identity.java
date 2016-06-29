package com.google.common.base;

import com.google.common.base.Equivalence;
import java.io.Serializable;

final class Equivalence$Identity extends Equivalence implements Serializable {
   static final Equivalence$Identity INSTANCE = new Equivalence$Identity();
   private static final long serialVersionUID = 1L;

   protected boolean doEquivalent(Object var1, Object var2) {
      return false;
   }

   protected int doHash(Object var1) {
      return System.identityHashCode(var1);
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
