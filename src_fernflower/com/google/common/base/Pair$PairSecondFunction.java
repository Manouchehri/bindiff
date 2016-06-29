package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Pair;
import java.io.Serializable;

final class Pair$PairSecondFunction implements Function, Serializable {
   static final Pair$PairSecondFunction INSTANCE = new Pair$PairSecondFunction();

   public Object apply(Pair var1) {
      return var1.getSecond();
   }

   private Object readResolve() {
      return INSTANCE;
   }
}
